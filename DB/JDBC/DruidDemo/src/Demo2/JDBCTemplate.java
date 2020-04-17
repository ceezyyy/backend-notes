package Demo2;


import Demo1.Utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.SplittableRandom;

public class JDBCTemplate {

    /*
     * 利用 JUnit 单元测试
     * */

    // 改
    @Test
    public void test1() {
        // 创建 JDBC template 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "update emp set name = ? where id = 5";

        // 执行 CRUD 操作
        int count = jdbcTemplate.update(sql, "爱彼迎");
        System.out.println(count);
    }

    // 增
    @Test
    public void test2() {
        // 创建 Jdbctemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

        // sql 语句
        String sql = "insert into emp(id, name, gender, salary, come, dept_id) values (null, ?, ?, ?, ?, ?)";

        // 执行操作
        int count = jdbcTemplate.update(sql, "菜鸟网络", "f", 232323, "2020-03-03", 1);
        System.out.println(count);
    }

    // 删
    @Test
    public void test3() {
        // 创建 jdbctemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "delete from emp where id = 28";

        int count = jdbcTemplate.update(sql);
        System.out.println(count);
    }

    // 查
    @Test
    public void test4() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "select * from emp";

        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> map : mapList) {
            System.out.println(map);
        }
    }
}

