# MyBatis Plus

<div align="center"> <img src="logo.png" width="60%"/> </div><br>




Table of Contents
-----------------

* [前期准备](#前期准备)
* [1. 查询方法](#1-查询方法)
* [2. 自定义 sql](#2-自定义-sql)
* [3. 分页](#3-分页)
* [4. 更新 &amp; 删除](#4-更新--删除)
* [5. AR 模式 &amp; 主键策略](#5-ar-模式--主键策略)
* [6. 通用 service](#6-通用-service)
* [7. 逻辑删除](#7-逻辑删除)
* [8. 自动填充](#8-自动填充)
* [9. 乐观锁](#9-乐观锁)
* [10. 性能分析](#10-性能分析)
* [11. 多租户](#11-多租户)
* [12. 动态表](#12-动态表)
* [13. SQL 注入器](#13-sql-注入器)
* [参考链接](#参考链接)


## 前期准备

建表：

```sql
SHOW DATABASES;

CREATE DATABASE mp;

USE mp;

-- 创建用户表
CREATE TABLE user (
  id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键',
  name VARCHAR(30) DEFAULT NULL COMMENT '姓名',
  age INT(11) DEFAULT NULL COMMENT '年龄',
  email VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  manager_id BIGINT(20) DEFAULT NULL COMMENT '直属上级id',
  create_time DATETIME DEFAULT NULL COMMENT '创建时间',
  CONSTRAINT manager_fk FOREIGN KEY (manager_id)
  REFERENCES user (id)
)  ENGINE=INNODB CHARSET=UTF8;

-- 初始化数据：
INSERT INTO user (id, name, age, email, manager_id
                  , create_time)
VALUES (1087982257332887553, '大boss', 40, 'boss@baomidou.com', NULL
        , '2019-01-11 14:20:20'),
	(1088248166370832385, '王天风', 25, 'wtf@baomidou.com', 1087982257332887553
   , '2019-02-05 11:12:22'),
	(1088250446457389058, '李艺伟', 28, 'lyw@baomidou.com', 1088248166370832385
   , '2019-02-14 08:31:16'),
	(1094590409767661570, '张雨琪', 31, 'zjq@baomidou.com', 1088248166370832385
   , '2019-01-14 09:15:15'),
	(1094592041087729666, '刘红雨', 32, 'lhm@baomidou.com', 1088248166370832385
   , '2019-01-14 09:48:16');
```

<div align="center"> <img src="image-20200826100803752.png" width="80%"/> </div><br>

引入依赖：

**pom.xml**

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-boot-starter -->
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.2.0</version>
  </dependency>
  <dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.2.0</version>
  </dependency>
  <!-- 模板引擎 -->
  <dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.0</version>
  </dependency>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
    <exclusions>
      <exclusion>
        <groupId>org.junit.vintage</groupId>
        <artifactId>junit-vintage-engine</artifactId>
      </exclusion>
    </exclusions>
  </dependency>
</dependencies>
```

配置文件：

**application.yml**

```yaml
#用来控制使用哪个配置文件deve/prod 开发环境/生产环境
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mp?useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true&autoReconnect=true&characterEncoding=utf-8
    username: root
    password: yourpassword

#日志配置:trace,最低级别日志输出
logging:
  level:
    #    root: info
    root: warn
    com.lf.mp.dao: trace
```

`mp` 代码生成器：

（改成适配自己项目，需配合官方文档及源码！耐心！）

**CodeGenerator.java**

```java
package com.ceezyyy.demo.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

  /**
     * <p>
     * 读取控制台内容
     * </p>
     */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(projectPath + "/src/main/java");
    gc.setAuthor("ceezyyy");
    gc.setOpen(false);
    // gc.setSwagger2(true); 实体属性 Swagger2 注解
    gc.setIdType(IdType.UUID);
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:mysql://localhost:3306/mp?useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true&autoReconnect=true&characterEncoding=utf-8");
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("727800Cy$");
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName(scanner("模块名"));
    pc.setParent("com.ceezyyy");
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };

    // 如果模板引擎是 velocity
    String templatePath = "/templates/mapper.xml.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
          + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
      }
    });
    /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    // templateConfig.setEntity("templates/entity2.java");
    // templateConfig.setService();
    // templateConfig.setController();

    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    //        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    // 公共父类
    //        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
    // 写于父类中的公共字段
    //        strategy.setSuperEntityColumns("id");
    strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix(pc.getModuleName() + "_");
    mpg.setStrategy(strategy);
    //        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
  }

}
```



## 1. 查询方法

**BaseMapper.java**

```java
public interface BaseMapper<T> extends Mapper<T> {

    T selectById(Serializable id);

    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);

    List<T> selectByMap(@Param("cm") Map<String, Object> columnMap);

    T selectOne(@Param("ew") Wrapper<T> queryWrapper);

    Integer selectCount(@Param("ew") Wrapper<T> queryWrapper);

    List<T> selectList(@Param("ew") Wrapper<T> queryWrapper);

    List<Map<String, Object>> selectMaps(@Param("ew") Wrapper<T> queryWrapper);

    List<Object> selectObjs(@Param("ew") Wrapper<T> queryWrapper);

    IPage<T> selectPage(IPage<T> page, @Param("ew") Wrapper<T> queryWrapper);

    IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param("ew") Wrapper<T> queryWrapper);
}
```





## 2. 自定义 sql 



## 3. 分页

## 4. 更新 & 删除

## 5. AR 模式 & 主键策略

## 6. 通用 service

## 7. 逻辑删除

## 8. 自动填充

## 9. 乐观锁

## 10. 性能分析

## 11. 多租户

## 12. 动态表

## 13. SQL 注入器



## 总结

- 实践出真知
- 官网提供的例子 / 工具类要懂得如何改成适合自己项目

## 参考链接

- [MyBatis-Plus](https://baomidou.com/)
- [MyBatis-Plus入门](https://www.imooc.com/learn/1130)
- [MyBatis-Plus进阶](https://www.imooc.com/learn/1171)
