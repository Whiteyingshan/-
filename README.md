# 数据库地址更改：

修改first\springboot\src\main\resources路径下的application.yaml文件

```
datasource:
    #数据库用户名
    username: root
    #数据库密码
    password: 123456
    #数据库类型
    driver-class-name: com.mysql.cj.jdbc.Driver
    #数据库路径
    url: jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&useSSL=false
```

# swagger地址

http://127.0.0.1:8081/swagger-ui/index.html
