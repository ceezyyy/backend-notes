package jdbcDemo4;


import java.sql.*;

public class JdbcDemo4 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "727800");

            statement = connection.createStatement();
            String s = "Select * from emp";
            ResultSet resultSet = statement.executeQuery(s);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Double salary = resultSet.getDouble("salary");
                Date date = resultSet.getDate("come");
                int dept_id = resultSet.getInt("dept_id");

                System.out.println(id + "  " + name + "  " + gender + "  " + salary + "  " + date + "  " + dept_id);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



