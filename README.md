# Springboot+MyBatisPlus实现用户CRUD操作

### 1.版本

Springboot版本：3.0.2

JDK17

MAVEN：3.8.1

IDEA：2023.1

MYSQL服务器5.7版本

### 2.数据库表

本代码中使用的是本地库ums中的user表，具体创建语句如下：

```mysql
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(20) DEFAULT NULL,
  password varchar(255) NOT NULL,
  birthday date DEFAULT NULL,
  sex char(1) DEFAULT NULL,
  address varchar(100) DEFAULT NULL,
  roleId int(11) DEFAULT NULL,
  deleted int(11) NOT NULL DEFAULT '0' COMMENT '0：未删除 1：已删除',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
```



### 3.注意

本项目中除了config包，util包，UserController中的代码以及主程序类，其它代码均为MyBatisPlus代码生成器工具类自动生成。