package com.lounwb.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis工具类
 * @author Lounwb
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSessionUtil() {
    }
    static{
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();
    /**
     * 获取会话对象
     * @return 会话对象
     */
    public static SqlSession openSqlSession(){
        SqlSession sqlSession = local.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭SqlSession对象——从当前线程中移除SqlSession对象
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
            local.remove();
        }
    }
}
