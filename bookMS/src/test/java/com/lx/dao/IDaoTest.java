package com.lx.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.InputStream;

public class IDaoTest {

    protected InputStream in;
    protected SqlSessionFactory factory;
    protected SqlSession session;

    @Before
    public void init() throws Exception {
//       读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//       创建工厂
        factory = new SqlSessionFactoryBuilder().build(in);
//       创建Session
        session = factory.openSession();
    }

    @After
    public void finish() throws Exception {
        System.out.println("session已销毁");
        session.commit();
        session.close();
        in.close();
    }
}
