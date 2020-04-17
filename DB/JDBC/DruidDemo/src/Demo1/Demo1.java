package Demo1;


import Demo1.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 获取连接
            connection = JDBCUtils.getConnection();

            // 执行的 sql 语句
            String sql = "insert into emp(id, name, gender, salary, come, dept_id) values (null, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            // 赋值
            preparedStatement.setString(1, "HUAWEI");
            preparedStatement.setString(2, "m");
            preparedStatement.setDouble(3, 90909090);
            preparedStatement.setDate(4, Date.valueOf("2020-06-01"));
            preparedStatement.setInt(5, 3);

            // 执行
            int count = preparedStatement.executeUpdate();

            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement, connection);
        }
    }
}




