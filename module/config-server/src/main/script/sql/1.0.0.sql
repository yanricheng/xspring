create table config_properties(
  id bigint not null AUTO_INCREMENT COMMENT 'id',
  app_id  bigint not null  COMMENT 'app_id',
  env_id bigint not null COMMENT '环境id',
  task_id  bigint not null COMMENT '任务id',
  config_key varchar(1024) not null COMMENT 'key',
  config_value longtext not null,
  creator varchar(64) DEFAULT NULL COMMENT '创建人',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  last_editor varchar(64) DEFAULT NULL COMMENT '修改人',
  last_edit_time datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY key(id)
)engine=innoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE config_modify_history(
  id bigint not null AUTO_INCREMENT comment 'id',
  config_properties_id bigint not null  comment '配置属性id',
  content longtext not null comment '变更内容',
  operate_time datetime not  NULL COMMENT '操作时间',
  operator VARCHAR(64) not null COMMENT '操作人',
  PRIMARY key(id)
)engine=innoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` int(11) DEFAULT NULL COMMENT '活动类型 1：普通 2：征稿',
  `is_delete` int(11)  NOT NULL DEFAULT 1 COMMENT '是否删除 0：否，1：是',
  `status` int(11)  NOT NULL DEFAULT 1 COMMENT '是否删除 0：否，1：是',
  `title` varchar(64) DEFAULT NULL COMMENT '活动标题',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `start_time` datetime DEFAULT NULL COMMENT '活动开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '活动结束时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_editor` varchar(64) DEFAULT NULL COMMENT '修改人',
  `last_edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;