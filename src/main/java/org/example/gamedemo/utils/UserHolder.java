package org.example.gamedemo.utils;
import org.example.gamedemo.dto.UserDTO;
public class UserHolder {
    // 创建一个 ThreadLocal 实例，用于存储 UserDTO 对象
    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();
// static 关键字保证了在整个应用程序中只有一个 ThreadLocal 实例，
// final 关键字确保该实例不可被重新赋值。

    // 保存用户信息到当前线程的 ThreadLocal 中
    public static void saveUser(UserDTO user){
        tl.set(user);
    }

    // 从当前线程的 ThreadLocal 中获取用户信息
    public static UserDTO getUser(){
        return tl.get();
    }

    // 从当前线程的 ThreadLocal 中移除用户信息
    public static void removeUser(){
        tl.remove();
    }

}
