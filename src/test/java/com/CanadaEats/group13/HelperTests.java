package com.CanadaEats.group13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelperTests {

    @Test
    public void addTest() {
        Helper helper = new Helper();
        int result = helper.add(10, 10);
        Assertions.assertEquals(20, result);
    }
}