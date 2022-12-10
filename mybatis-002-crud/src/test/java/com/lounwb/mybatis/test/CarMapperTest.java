package com.lounwb.mybatis.test;

import com.lounwb.mybatis.pojo.Car;
import com.lounwb.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = new Car(null,"3333","比亚迪秦", 30.0, "2020-11-22", "新能源");
        sqlSession.insert("insertCar", car);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();

        Map<String, Object> map = new HashMap<>();

        map.put("carNum", 222);
        map.put("brand", "比亚迪宋");
        map.put("guidePrice", 10.0);
        map.put("produceTime", "2022-12-22");
        map.put("carType", "新能源");
        sqlSession.insert("insertCar", map);

        sqlSession.commit();
        sqlSession.close();
    }
}
