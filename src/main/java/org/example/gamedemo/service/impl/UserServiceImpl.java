package org.example.gamedemo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.gamedemo.dto.LoginFormDTO;
import org.example.gamedemo.dto.Result;
import org.example.gamedemo.dto.UserDTO;
import org.example.gamedemo.entity.User;
import org.example.gamedemo.mapper.UserMapper;
import org.example.gamedemo.service.IUserService;
import org.example.gamedemo.utils.RegexUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static org.example.gamedemo.utils.RedisConstants.*;
import static org.example.gamedemo.utils.SystemConstants.USER_NICK_NAME_PREFIX;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

//    @Resource
//    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Result sendCode(String phone, HttpSession session) {
        // 1.校验手机号
        if (RegexUtils.isPhoneInvalid(phone)) {
            // 2.如果不符合，返回错误信息
            return Result.fail("number pattern wrong");
        }
        // 3.符合，生成验证码
        String code = RandomUtil.randomNumbers(6);

        // 4.保存验证码到 session
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);
//        TimeUnit是java自带工具类里面的
        session.setAttribute("code", code);
        // 5.发送验证码
        log.info("发送短信验证码成功，验证码：{}", code);
        //没有真的发，只是模拟一下
        // 返回ok
        return Result.ok();
    }

    @Override
    public Result loginCode(LoginFormDTO loginForm) {
        // 1.校验手机号
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            // 2.如果不符合，返回错误信息
            return Result.fail("手机号格式错误！");
        }
        // 3.从redis获取验证码并校验
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + phone);
//        String cacheCode = session.getAttribute("code");
        String code = loginForm.getCode();
        //前端提交的code
        if (cacheCode == null || !cacheCode.equals(code)) {
            // 不一致，报错
            return Result.fail("验证码错误");
        }
        //反向判断可以避免if-else嵌套

        // 4.一致，根据手机号查询用户 select * from tb_user where phone = ?
        User user = query().eq("phone", phone).one();
        // mybatisPlus
        // 因为继承了extends ServiceImpl<UserMapper, User>这是来自mybatisPlus
        // 这样就会去对应的表查询

        // 5.判断用户是否存在
        if (user == null) {
            // 6.不存在，创建新用户并保存
            user = createUserWithPhone(phone);
        }

        // 7.保存用户信息到 redis中
//        session.setAttribute("user",user);
        // 存到session里的就不应该是完整的而应该是部分的信息
//        session.setAttribute("user",BeanUtil.copyProperties(user,UserDTO.class));
        // 这样登录以后存进去的就是UserDTO
        // 7.1.随机生成token，作为登录令牌
        String token = UUID.randomUUID().toString(true);
        // 7.2.将User对象转为HashMap存储
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO);
        // 7.3.存储
        String tokenKey = LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(tokenKey, userMap);
        // 7.4.设置token有效期
        stringRedisTemplate.expire(tokenKey, LOGIN_USER_TTL, TimeUnit.MINUTES);

        // 8.返回token
        return Result.ok(token);
    }
    private User createUserWithPhone(String phone) {
        // 1.创建用户
        User user = new User();
        user.setPhone(phone);
        user.setNickName(USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        // 2.保存用户
        save(user);
        return user;
    }

    @Override
    public Result loginPsw(LoginFormDTO loginForm) {
//        // ... existing code ...
//
//        // 5.校验密码
//        String inputPassword = loginForm.getPassword();
//        String storedPassword = user.getPassword();
//        if (!passwordEncoder.matches(inputPassword, storedPassword)) {
//            return Result.fail("密码错误");
//        }
//
//        // ... existing code ...
        return Result.ok();
    }

    @Override
    public Result sign() {
        return null;
    }

    @Override
    public Result signCount() {
        return null;
    }
}
