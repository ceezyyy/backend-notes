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
    /**
     * Description: UserDao test class
     *
     * @param:
     * @return:
     */
    private String resource;
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        // load resources
        resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        // create sqlsessionfactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // get session from sqlsessionfactory
        sqlSession = sqlSessionFactory.openSession();
        // get mapper
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
        /**
         * Description: find all user
         * @param: []
         * @return: void
         */
        // execute
        List<User> users = userDao.findAll();
        // result
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("LBJ");
        user.setSex("m");
        user.setAddress("USA");
        user.setBirthday(new Date());
        userDao.save(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(45);
        user.setUsername("Burberry");
        user.setBirthday(new Date());
        user.setSex("f");
        user.setAddress("UK");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        userDao.deleteUserById(42);
    }

    @Test
    public void testFindUserById() {
        User user = userDao.findUserById(45);
        System.out.println(user.toString());
    }

    @Test
    public void testFindUserByName() {
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
