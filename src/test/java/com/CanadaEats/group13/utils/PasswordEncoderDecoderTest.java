package com.CanadaEats.group13.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class PasswordEncoderDecoderTest {
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void encryptSuccessTest() {
        String encryptString = "arpit1234";
        String actualDecrytedString = "ftMn4rFs2L4HCX3lKnir8Q==";

        String result = PasswordEncoderDecoder.getInstance().encrypt(encryptString);

        assertEquals(actualDecrytedString, result);
    }

    @Test
    final void encryptFailureTest() {
        String encryptString = "arpit1234";
        String wrongDecrytedString = "ftMn4rFs2L4HCX";

        String result = PasswordEncoderDecoder.getInstance().encrypt(encryptString);

        assertNotEquals(result, wrongDecrytedString);
    }

    @Test
    final void decryptSuccessTest() {
        String edecryptString = "ftMn4rFs2L4HCX3lKnir8Q==";
        String actualEecrytedString = "arpit1234";

        String result = PasswordEncoderDecoder.getInstance().decrypt(edecryptString);

        assertEquals(actualEecrytedString, result);
    }

    @Test
    final void decryptFailureTest() {
        String edecryptString = "ftMn4rFs2L4HCX3lKnir8Q==";
        String wrongEecrytedString = "arpit";

        String result = PasswordEncoderDecoder.getInstance().decrypt(edecryptString);

        assertNotEquals(wrongEecrytedString, result);
    }
}
