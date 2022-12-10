package com.lounwb.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) {
        //获取SqlSessionFactoryBuilder对象用来创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = null;
        try {
            //mybatis自带的将配置文件转换成流 resource as stream
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        //用SqlSessionFactory来创建一次会话SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        int count = sqlSession.insert("insertCar");

        System.out.println("插入了" + count + "条数据");

        sqlSession.commit();

    }
}
