-- 创建用户信息数据库
create database users;

-- 使用用户信息数据库
use users;

-- 创建用户账号信息表
create table accounts(username varchar(100),password varchar(100));

-- 插入几条数据用于测试登录功能
insert into accounts values("zhangsan","zs123");
insert into accounts values("lisi","ls456");
insert into accounts values("小明","xm789");

-- 查询一下用户账户信息表 看有没有数据
select * from accounts;