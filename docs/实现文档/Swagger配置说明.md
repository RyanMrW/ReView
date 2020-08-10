## 配置

Swagger的配置文件在backend/kit/src/main/java/com/example/kit/config/SwaggerConfig.class中。



## 使用

### Controller前

```java
@Api(tags = "用户管理接口") 
```

### Api接口前

描述接口

```java
@ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
```

描述参数

```java
@ApiImplicitParams({
	@ApiImplicitParam(name = "userName", value = "用户名", required = true, defaultValue = "admin", dataType = "String")
})
```

### Model中

描述类信息

```java
@ApiModel
```

描述类的属性

```java
 @ApiModelProperty(value = "用户id")
```



## 访问

swagger的路径为[http://localhost:36036/web/swagger-ui.html](http://localhost:36036/web/swagger-ui.html)