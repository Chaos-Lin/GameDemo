-- 测试数据
use game_demo;

start transaction ;

begin;
-- 用户
INSERT INTO `users` (`user_name`, `password`, `email`, `created_at`) VALUES
                                                                        ('game_lover', '$2a$10$xJwL5v5zQ3V6Xp5Q7f8JZe', 'gamer@example.com', '2023-01-15 10:00:00'),
                                                                        ('pro_gamer', '$2a$10$yKv8H9wT2R5Wq3E4t5Y6Uu', 'pro@example.com', '2023-02-20 11:30:00'),
                                                                        ('rpg_fan', '$2a$10$zLx9N8v7B6M5Q4W3E2R1Tq', 'rpgfan@example.com', '2023-03-10 09:15:00'),
                                                                        ('fps_king', '$2a$10$aBc1D2e3F4G5H6I7J8K9L0', 'fpsking@example.com', '2023-04-05 14:20:00'),
                                                                        ('indie_dev', '$2a$10$mN0bV9c8X7Z6Y5W4U3T2S1', 'dev@example.com', '2023-05-12 16:45:00');

commit ;

begin;
-- 游戏库
INSERT INTO `games` (`game_name`, `description`, `created_at`) VALUES
                                                                   ('艾尔登法环', 'FromSoftware开发的开放世界动作RPG游戏', '2023-01-10 00:00:00'),
                                                                   ('赛博朋克2077', 'CD Projekt Red开发的未来科幻RPG游戏', '2023-01-12 00:00:00'),
                                                                   ('原神', '米哈游开发的开放世界动作角色扮演游戏', '2023-01-15 00:00:00'),
                                                                   ('英雄联盟', 'Riot Games开发的多人在线战斗竞技游戏', '2023-02-01 00:00:00'),
                                                                   ('星露谷物语', 'ConcernedApe开发的农场模拟RPG游戏', '2023-02-10 00:00:00');
commit;

begin;
-- 笔记
INSERT INTO `notes` (`user_id`, `game_id`, `title`, `content`, `images`, `liked`, `comments`) VALUES
                                                                                                  (1, 1, '艾尔登法环新手攻略', '这篇攻略将帮助新手玩家快速上手...', '/images/guide1.jpg,/images/guide2.jpg', 25, 8),
                                                                                                  (2, 2, '赛博朋克2077完美结局达成条件', '经过多次尝试，我发现了达成所有结局的条件...', '/images/ending1.jpg', 42, 15),
                                                                                                  (3, 3, '原神3.0版本角色强度排行', '根据最新版本测试得出的角色强度分析...', '/images/tierlist.jpg', 38, 22),
                                                                                                  (4, 4, '英雄联盟新赛季上分指南', '分享我的上分经验和英雄选择建议...', NULL, 15, 5),
                                                                                                  (1, 5, '星露谷物语第一年完美规划', '如何最大化利用第一年的时间...', '/images/farm1.jpg,/images/farm2.jpg', 56, 18);

commit;

begin;
-- 标签
INSERT INTO `note_tags` (`tag_name`, `created_at`) VALUES
                                                       ('攻略', '2023-01-01 00:00:00'),
                                                       ('评测', '2023-01-01 00:00:00'),
                                                       ('技巧', '2023-01-01 00:00:00'),
                                                       ('剧情', '2023-01-01 00:00:00'),
                                                       ('多人游戏', '2023-01-01 00:00:00');

commit;

begin;
-- 笔记标签
INSERT INTO `note_tag_relations` (`note_id`, `tag_id`) VALUES
                                                           (1, 1), (1, 3),  -- 艾尔登法环新手攻略: 攻略, 技巧
                                                           (2, 1), (2, 4),  -- 赛博朋克2077完美结局: 攻略, 剧情
                                                           (3, 2), (3, 3),  -- 原神角色强度排行: 评测, 技巧
                                                           (4, 1), (4, 5),  -- 英雄联盟上分指南: 攻略, 多人游戏
                                                           (5, 1), (5, 3);  -- 星露谷物语规划: 攻略, 技巧

commit;

begin;
-- 笔记点赞
INSERT INTO `note_likes` (`note_id`, `user_id`, `created_at`) VALUES
(1, 2, '2023-01-16 11:00:00'),
(1, 3, '2023-01-17 14:30:00'),
(2, 1, '2023-02-21 09:15:00'),
(2, 4, '2023-02-22 16:45:00'),
(3, 2, '2023-03-11 10:20:00'),
(3, 5, '2023-03-12 13:10:00'),
(4, 3, '2023-04-06 15:30:00'),
(5, 1, '2023-05-13 11:45:00'),
(5, 4, '2023-05-14 17:20:00');
commit;

begin;
-- 笔记评论
INSERT INTO `note_comments` (`note_id`, `user_id`, `content`, `created_at`) VALUES
                                                                          (1, 2, '感谢分享，对我帮助很大！', '2023-01-16 11:05:00'),
                                                                                (1, 3, '有些地方不太明白，能详细解释下吗？', '2023-01-17 14:35:00'),
                                                                                (2, 1, '原来还有这个隐藏结局，太棒了！', '2023-02-21 09:20:00'),
                                                                                (3, 4, '不同意你的排行，我认为XX角色更强', '2023-03-11 10:25:00'),
                                                                                (3, 5, '很全面的分析，期待下期更新', '2023-03-12 13:15:00'),
                                                                                (4, 3, '我用你的方法已经上了一个段位了', '2023-04-06 15:35:00'),
                                                                                (5, 1, '第一年就能完成这么多？太厉害了', '2023-05-13 11:50:00');
commit;

UPDATE users
SET phone = '18015267977'
WHERE user_id = '3';
