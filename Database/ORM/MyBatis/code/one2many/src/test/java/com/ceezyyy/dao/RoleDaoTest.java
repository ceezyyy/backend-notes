package com.ceezyyy.dao;

import com.ceezyyy.domain.Role;
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

public class RoleDaoTest {

    private String resource;
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before
    public void init() throws IOException {
        resource = "SqlMapConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testRoleFindAll() {
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testFindAllRoles() {
        List<Role> allRoles = roleDao.findAllRoles();
        for (Role role : allRoles) {
            System.out.println(role);
            System.out.println();
        }
    }
}
