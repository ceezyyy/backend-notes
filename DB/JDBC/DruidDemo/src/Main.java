import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        // new 一个 properties 对象
        Properties pro = new Properties();

        // 加载配置文件
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(inputStream);

        // 创建连接池工厂
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        // 获取连接
        Connection connection = dataSource.getConnection();

        // 输出结果
        System.out.println(connection);
    }
}
