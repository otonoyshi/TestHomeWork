package me.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


public class MainTest {

    @Test
    public void earningTest(){
        Main main = new Main();
        int a = 5000;
        int actual= main.getEarnings(a);
        Assertions.assertTrue(actual != 0);

    }

    @ParameterizedTest
    @ValueSource(ints = {1000})
    public void textTest(int a){
        Main main = new Main();
        int b = 10000;
        int condition = 1;
        int actual = main.text(a, b);
        Assertions.assertEquals(condition,actual);
    }


    @ParameterizedTest
    @ValueSource(ints = {10000,15000})
    public void taxTest(int a){
        Main main = new Main();
        int b = 15000;
        int expect = 0;
        int actual = main.taxEarningsMinusSpendings(a,b);
        Assertions.assertEquals(expect,actual);
    }

    @Test
    public void mainTest(){
        Main main = new Main();
        String a = "end";
        int expect = 404;
        int actual = main.main(a);
        Assertions.assertEquals(expect,actual);
    }



}
