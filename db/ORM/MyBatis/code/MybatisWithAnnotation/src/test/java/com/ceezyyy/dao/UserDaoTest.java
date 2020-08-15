package com.ceezyyy.dao;

import com.ceezyyy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {

    private String resource;
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("Higher Brothers");
        user.setBirthday(new Date());
        user.setSex("m");
        user.setAddress("La");
        userDao.createUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(46);
        user.setUsername("3ho");
        user.setBirthday(new Date());
        user.setSex("m");
        user.setAddress("San francisco");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        userDao.deleteUserById(43);
    }

    @Test
    public void testGetTotalCount() {
        int totalCount = userDao.getTotalCount();
        System.out.println(totalCount);
    }

    @Test
    public void testFindUserById() {
        User user = userDao.findUserById(45);
        System.out.println(user);
    }


}
