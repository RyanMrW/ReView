## ReView Base部分设计

### 用户管理

#### 数据库设计

| 字段            | 说明                  | 类型        |
| --------------- | --------------------- | ----------- |
| user_id         | ID，主键，自增        | int         |
| user_name       | 用户名，唯一          | varchar(45) |
| user_nickname   | 昵称，初始值user      | varchar(45) |
| user_password   | 密码，初始值123456    | varchar(45) |
| user_createtime | 创建时间，初始值Now() | datetime    |
| user_avatar     | 头像地址              | varchar(45) |
| user_role       | 用户身份，初始值3     | int         |



#### 用户身份

| 标号 | code        | 说明                       |
| ---- | ----------- | -------------------------- |
| 0    | sys_admin   | 系统管理员，唯一，管理用户 |
| 1    | topic_admin | TODO，话题管理员           |
| 2    | leader      | TODO，小组管理员           |
| 3    | user        | 使用者                     |



#### 功能

done

- 添加用户

- 删除用户

- 修改用户
- 查询某个用户全部信息
- 列出全部用户

todo

- 登录

- 登出

### 论文管理



