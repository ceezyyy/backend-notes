package com.company;

import com.company.domain.Emp;
import com.company.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Main {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Test
    public void testMethod1() {
        // Execute
        String sql = "update emp set salary = ? where id = 1";
        int count = jdbcTemplate.update(sql, 88888);

        // Result
        assertEquals(1, count);
    }

    @Test
    public void testMethod2() {
        String sql = "insert into emp(id, name, gender, salary, come, dept_id) values (?, ?, ?, ?, ?, ?)";
        int count = jdbcTemplate.update(sql, null, "BIGO", "m", 100000, "2020-05-01", 3);

        assertEquals(1, count);
    }

    @Test
    public void testMethod3() {
        String sql = "delete from emp order by id DESC limit 1";
        int count = jdbcTemplate.update(sql);

        assertEquals(1, count);
    }

    @Test
    public void testMethod4() {
        String sql = "select * from emp where id = 1";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);

        System.out.println(stringObjectMap);
    }

    @Test
    public void testMethod5() {
        String sql = "select * from emp";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void testMethod6() {
        String sql = "select * from emp";
        List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void testMethod7() {
        String sql = "select count(id) from emp";
        Integer query = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(query);
    }
}
