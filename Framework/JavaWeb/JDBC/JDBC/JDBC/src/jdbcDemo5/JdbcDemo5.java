package jdbcDemo5;


import domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcDemo5 {
    public static void main(String[] args) {
        List<Emp> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "727800");

            statement = connection.createStatement();
            String sql = "select * from emp";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                Date come = resultSet.getDate("come");
                int dept_id = resultSet.getInt("dept_id");

                Emp emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setCome(come);
                emp.setDept_id(dept_id);

                list.add(emp);

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
        for (Emp e : list) {
            System.out.println(e);
        }

    }


}



