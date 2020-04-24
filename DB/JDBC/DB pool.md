# 数据库连接池

## 什么是数据库连接池





## 为什么要用数据库连接池





## 常用数据库连接池：Druid

1. 下载依赖

   `MySQL` 相关驱动
   <div align="center"> <img src="image-20200417150738272.png" width="60%"/> </div><br>

   `Druid` 相关驱动
    <div align="center"> <img src="image-20200417151203504.png" width="50%"/> </div><br>

   最后记得 `Add as library`

2. 定义配置文件

<div align="center"> <img src="image-20200417151330811.png" width="40%"/> </div><br>

​		放到`src`目录下

​		配置文件

<div align="center"> <img src="image-20200417153154565.png" width="50%"/> </div><br>



3. 加载配置文件

4. 获取数据库连接池对象

5. 获取连接
<div align="center"> <img src="image-20200417154113804.png" width="100%"/> </div><br>

说明：

1. `Properties` 对象
<div align="center"> <img src="image-20200417154423951.png" width="100%"/> </div><br>



2. 文件 I / O 流





## JDBC Utils 

### 什么是 JDBC Utils?

`JDBC` 工具类。



### 为什么要用 JDBC Utils?

简化代码，将常用的操作例如初始化，获取连接，释放资源封装起来，使开发者调用更加方便高效。



### 如何实现 JDBC Utils?

```java
public class JDBCUtils {

    // 静态成员对象 -- 连接池对象
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        JDBCUtils.dataSource = dataSource;
    }

    // 静态方法块： 初始化赋值
    static {
        try {
            // 加载配置文件
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            // 对象池
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取 Connection 对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 释放资源 -> 2个重载方法
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 重载
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }

}

```

这里做个总结：

1. `static` 关键字表明的对象就是类对象，与对象无关；
2. `static` 代码块是给类作初始化的，而构造方法是给对象作初始化的。



## JDBC Template

### 什么是 JDBC Template?











### 为什么要用 JDBC Template?







### Quickstart

```java
    @Test
    public void test1() {
        // 创建 JDBC template 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "update emp set name = ? where id = 5";

        // 执行 CRUD 操作
        int count = jdbcTemplate.update(sql, "爱彼迎");
        System.out.println(count);
    }
    
```



```java
    @Test
    public void test4() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "select * from emp";

        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> map : mapList) {
            System.out.println(map);
        }
    }
    
```

