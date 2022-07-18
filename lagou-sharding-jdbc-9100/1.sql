create table user_info(
	id BIGINT(11) not null auto_increment comment '主键id',
	name varchar(100) comment '姓名',
	sex int(2) comment '性别',
	primary key(id)
)ENGINE=INNODB DEFAULT charset=utf8 comment='用户信息表';

create table b_order(
    id BIGINT(20) not null Auto_increment comment '主键id',
    company_id int(10) not null comment '公司id',
    user_id int(5) not null comment '用户id',
    name varchar(100) comment '名字',
    primary key(id)
)engine=innodb default charset=utf8 comment='订单表';