DROP TABLE activity
IF EXISTS;

CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` int(11) DEFAULT NULL COMMENT '活动类型 1：普通 2：征稿',
  `is_delete` int(11)  NOT NULL DEFAULT 1 COMMENT '是否删除 0：否，1：是',
  `status` int(11)  NOT NULL DEFAULT 1 COMMENT '是否删除 0：否，1：是',
  `title` varchar(64) DEFAULT NULL COMMENT '活动标题',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `start_time` datetime(3) DEFAULT NULL COMMENT '活动开始时间',
  `end_time` datetime(3) DEFAULT NULL COMMENT '活动结束时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `last_editor` varchar(64) DEFAULT NULL COMMENT '修改人',
  `last_edit_time` datetime(3) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `participantor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `is_delete` int(11) NOT NULL DEFAULT '1' COMMENT '是否删除 0：否，1：是',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT ' 0：正常，1：否',
  `title` varchar(64) DEFAULT NULL COMMENT '活动标题',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `last_editor` varchar(64) DEFAULT NULL COMMENT '修改人',
  `last_edit_time` datetime(3) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

