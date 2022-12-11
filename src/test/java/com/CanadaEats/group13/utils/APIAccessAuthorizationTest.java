package com.CanadaEats.group13.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

public class APIAccessAuthorizationTest {
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void getAPIAccessSuccessTest(){
        HttpServletRequest request = new TestHttpServletRequest();
        boolean result = APIAccessAuthorization.getInstance().getAPIAccess(request);

        assertTrue(result);
    }
}
