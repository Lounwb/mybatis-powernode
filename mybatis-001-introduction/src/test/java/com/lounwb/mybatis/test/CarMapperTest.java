package com.lounwb.mybatis.test;

import com.lounwb.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CarMapperTest {

    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int count = sqlSession.insert("insertCar");
        sqlSession.commit();
        sqlSession.close();
        System.out.println("插入:" + count + "条数据");
    }
    @Test
    public void testInsertCar(){
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
