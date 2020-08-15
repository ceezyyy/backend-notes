package com.ceezyyy.dao;

import com.ceezyyy.domain.Account;
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
import java.util.List;

public class UserDaoTest {
    private String resource;
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;
    private AccountDao accountDao;

    @Before
    public void init() throws IOException {
        resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testUserFindAll() {
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testAccountFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account ac : accounts) {
            System.out.println(ac);
        }
    }

    @Test
    public void testFindAccountUserAll() {
        List<Account> accountUserAll = accountDao.findAccountUserAll();
        for (Account account : accountUserAll) {
            System.out.println(" ");
            System.out.println(account.toString());
        }
    }

    @Test
    public void testFindAllAccountsOfUser() {
        List<User> users = userDao.findAllAccountsOfUser();
        for (User user : users) {
            System.out.println();
            System.out.println(user);
        }
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userDao.findAllUsers();
        for (User user : users) {
            System.out.println(user);
            System.out.println();
        }
    }


}
