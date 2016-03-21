package test;

/**
 * Created by GaBi on 27.01.2016.
 */

import CheckEvenOrOdd.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenOrOddTest {
    @BeforeClass

    public static void testSetup() {

    }

    @AfterClass

    public static void testCleanup() {

        // Teardown for data used by the unit tests

    }

    @Test(expected = IllegalArgumentException.class)

    public void testException1() {


        EvenOrOdd tester = new EvenOrOdd();

        tester.checkNumber("jgv");
    }
    @Test(expected = IllegalArgumentException.class)

    public void testException2() {


        EvenOrOdd tester1 = new EvenOrOdd();

        tester1.checkNumber("4,8");
    }

    @Test(expected = IllegalArgumentException.class)

    public void testException3() {


        EvenOrOdd tester2 = new EvenOrOdd();

        tester2.checkNumber("#");
    }

    @Test

    public void testEvenNumber() {


        EvenOrOdd tester = new EvenOrOdd();

        assertEquals("10 must be Even", true, tester.checkNumber("10"));
    }

    @Test

    public void testOddNumber() {


        EvenOrOdd tester = new EvenOrOdd();

        assertEquals("9 must be Even", false, tester.checkNumber("9"));
    }
}
