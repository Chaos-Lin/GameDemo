use game_demo;
CREATE TABLE `users` (
                         `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识',
                         `user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
                         `password` VARCHAR(100) NOT NULL COMMENT '用户密码（加密存储）',
                         `email` VARCHAR(100) NOT NULL COMMENT '用户邮箱',
                         `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账号创建时间',
                         PRIMARY KEY (`user_id`),
                         UNIQUE KEY `idx_username` (`user_name`),
                         UNIQUE KEY `idx_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `games` (
                         `game_id` INT NOT NULL AUTO_INCREMENT COMMENT '游戏唯一标识',
                         `game_name` VARCHAR(100) NOT NULL COMMENT '游戏名称',
                         `description` TEXT COMMENT '游戏简介',
                         `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '游戏添加时间',
                         PRIMARY KEY (`game_id`),
                         UNIQUE KEY `idx_game_name` (`game_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='游戏库表';

CREATE TABLE `notes` (
                         `id` INT NOT NULL AUTO_INCREMENT COMMENT '笔记唯一标识',
                         `user_id` INT NOT NULL COMMENT '发布笔记的用户ID',
                         `game_id` INT NOT NULL COMMENT '笔记关联的游戏库ID',
                         `title` VARCHAR(255) NOT NULL COMMENT '笔记标题',
                         `content` TEXT NOT NULL COMMENT '笔记内容',
                         `images` VARCHAR(2048) DEFAULT NULL COMMENT '笔记中的图片链接（多个用逗号分隔）',
                         `liked` INT DEFAULT 0 COMMENT '点赞数',
                         `comments` INT DEFAULT 0 COMMENT '评论数',
                         `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '笔记创建时间',
                         `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '笔记最后更新时间',
                         PRIMARY KEY (`id`),
                         KEY `idx_user_id` (`user_id`),
                         KEY `idx_game_id` (`game_id`),
                         CONSTRAINT `fk_notes_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
                         CONSTRAINT `fk_notes_game` FOREIGN KEY (`game_id`) REFERENCES `games` (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='笔记表';

CREATE TABLE `note_tags` (
                             `tag_id` INT NOT NULL AUTO_INCREMENT COMMENT '标签唯一标识',
                             `tag_name` VARCHAR(50) NOT NULL COMMENT '标签名称',
                             `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '标签创建时间',
                             PRIMARY KEY (`tag_id`),
                             UNIQUE KEY `idx_tag_name` (`tag_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='笔记标签表';

CREATE TABLE `note_tag_relations` (
                                      `note_id` INT NOT NULL COMMENT '笔记ID',
                                      `tag_id` INT NOT NULL COMMENT '标签ID',
                                      PRIMARY KEY (`note_id`, `tag_id`),
                                      KEY `idx_tag_id` (`tag_id`),
                                      CONSTRAINT `fk_relation_note` FOREIGN KEY (`note_id`) REFERENCES `notes` (`id`),
                                      CONSTRAINT `fk_relation_tag` FOREIGN KEY (`tag_id`) REFERENCES `note_tags` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='笔记与标签关联表';

CREATE TABLE `note_likes` (
                              `like_id` INT NOT NULL AUTO_INCREMENT COMMENT '点赞唯一标识',
                              `note_id` INT NOT NULL COMMENT '被点赞的笔记ID',
                              `user_id` INT NOT NULL COMMENT '点赞的用户ID',
                              `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
                              PRIMARY KEY (`like_id`),
                              UNIQUE KEY `idx_note_user` (`note_id`, `user_id`),
                              KEY `idx_user_id` (`user_id`),
                              CONSTRAINT `fk_like_note` FOREIGN KEY (`note_id`) REFERENCES `notes` (`id`),
                              CONSTRAINT `fk_like_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='笔记点赞表';

CREATE TABLE `note_comments` (
                                 `comment_id` INT NOT NULL AUTO_INCREMENT COMMENT '评论唯一标识',
                                 `note_id` INT NOT NULL COMMENT '被评论的笔记ID',
                                 `user_id` INT NOT NULL COMMENT '评论的用户ID',
                                 `content` TEXT NOT NULL COMMENT '评论内容',
                                 `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
                                 PRIMARY KEY (`comment_id`),
                                 KEY `idx_note_id` (`note_id`),
                                 KEY `idx_user_id` (`user_id`),
                                 CONSTRAINT `fk_comment_note` FOREIGN KEY (`note_id`) REFERENCES `notes` (`id`),
                                 CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='笔记评论表';

-- 假设用户表名为 tb_user，新增一个名为 phone 的 VARCHAR(11) 类型的列，用于存储手机号
ALTER TABLE users
    ADD COLUMN phone VARCHAR(11) NULL COMMENT '用户手机号';

