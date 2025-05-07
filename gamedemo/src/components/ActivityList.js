import React, { useEffect, useState } from 'react';
import { getActivityList } from '../api';

const ActivityList = () => {
    const [activities, setActivities] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getActivityList();
                setActivities(response.data);
            } catch (error) {
                console.error('获取活动列表失败:', error);
            }
        };
        fetchData();
    }, []);

    return (
        <div>
            <h2>活动列表</h2>
            <ul>
                {activities.map((activity) => (
                    <li key={activity.id}>{activity.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default ActivityList;