import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080', // 根路径
    headers: {
        'Content-Type': 'application/json'
    }
});

// 活动相关接口（保持与后端 @RequestMapping("/activity") 一致）
export const getActivityList = () => api.get('/activity/list');
export const getActivityDetail = (activityId) => api.get(`/activity/detail/${activityId}`);
export const createActivity = (activityData) => api.post('/activity/create', activityData);
export const updateActivity = (activityData) => api.post('/update', activityData);
export const deleteActivity = (activityId) => api.post(`/delete/${activityId}`);

// 状态流转接口（根据后端 IActivityService 接口添加）
export const arraignment = (activityId) => api.post(`/arraignment/${activityId}`);
export const checkPass = (activityId) => api.post(`/checkPass/${activityId}`);
export const checkRefuse = (activityId) => api.post(`/checkRefuse/${activityId}`);
export const checkRevoke = (activityId) => api.post(`/checkRevoke/${activityId}`);
export const closeActivity = (activityId) => api.post(`/close/${activityId}`);

// 其他接口可以按照类似方式添加

// 抽奖相关接口
export const startLottery = (activityId) => api.post(`/lottery/start/${activityId}`);
export const participateLottery = (activityId, userId) => api.post(`/lottery/participate/${activityId}`, { userId });
export const getLotteryResult = (activityId, userId) => api.get(`/lottery/result/${activityId}/${userId}`);

// 发奖相关接口
export const issueAward = (awardId, userId) => api.post(`/award/issue/${awardId}?userId=${userId}`);
export const getAwardList = (userId) => api.get(`/award/list/${userId}`);
export const claimAward = (awardId) => api.post(`/award/claim/${awardId}`);

// 用户相关接口
export const getUserInfo = () => api.get('/user/info');
export const updateUserProfile = (userData) => api.put('/user/profile', userData);