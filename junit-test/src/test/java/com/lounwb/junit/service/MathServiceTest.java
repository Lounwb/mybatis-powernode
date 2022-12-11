package com.lounwb.junit.service;

import org.junit.Assert;
import org.junit.Test;

public class MathServiceTest {
    //test
    @Test
    public void testSum(){
        MathService ms = new MathService();
        int actual = ms.sum(1, 2);
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSub(){
        MathService ms = new MathService();
        int actual = ms.sub(10, 2);
        int expected = 8;
        Assert.assertEquals(expected, actual);
    }
}
