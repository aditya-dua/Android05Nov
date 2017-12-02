package com.adityadua.testingdeployment5ndemo;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    String email;

    @Before
    public void initData(){


        email="aditya.dua@adityadua.coa";

    }
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }

    @Test
    public void checkProductOfTwoNumbers(){
        assertEquals("Wrong multiplication",10,5*2);
    }

    @Test
    public void checkEmail(){

        boolean containscom=email.contains(".com");
        boolean contains2 = false;
        if(containscom){
            contains2 = email.contains("@");

        }
        //assertEquals("Email Validation : Failed , please check",true,contains2);
        assertEquals("Double test",10,12,4);

    }
    @After
    public void clearData(){
        email="";
    }
}