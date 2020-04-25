package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static DataSource dataSource = null;

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Return DataSource
    public static DataSource getDataSource() {
        return dataSource;
    }

    // Return Connection of DataSource
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
