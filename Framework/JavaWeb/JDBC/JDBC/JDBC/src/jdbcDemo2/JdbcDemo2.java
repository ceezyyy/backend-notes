package jdbcDemo2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "727800");
            String s = "insert into emp(id, name, gender, salary, come, dept_id) values (null, '中国平安', 'm', 345354, '2020-04-10', 1)";
            statement = connection.createStatement();
            int result = statement.executeUpdate(s);
            if (result > 0) {
                System.out.println("Succeed!");
            } else {
                System.out.println("Fail!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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
    }
}



