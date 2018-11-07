package com.fundamentals.multythreadingexcercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class FirstTest {


    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void firstTest() {
        System.out.println("in first test");
        assertTrue(true);
    }
}
