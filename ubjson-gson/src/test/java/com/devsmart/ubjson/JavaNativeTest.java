package com.devsmart.ubjson;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaNativeTest {

    @Test
    public void testConvertNull() {
        UBValue value = ObjectUtil.toUBValue(null);
        assertNotNull(value);
        assertTrue(value.isNull());
    }

    @Test
    public void testConvertString() {
        final String strValue = "hello world";
        UBValue value = ObjectUtil.toUBValue(strValue);
        assertNotNull(value);
        assertTrue(value.isString());
        assertEquals(strValue, value.asString());
    }

    @Test
    public void testConvertBool() {
        UBValue value = ObjectUtil.toUBValue(true);
        assertNotNull(value);
        assertTrue(value.isBool());
        assertTrue(value.asBool());

        value = ObjectUtil.toUBValue(false);
        assertNotNull(value);
        assertTrue(value.isBool());
        assertFalse(value.asBool());

    }

    @Test
    public void testConvertInt() {
        final int intValue = 364;
        UBValue value = ObjectUtil.toUBValue(intValue);
        assertNotNull(value);
        assertTrue(value.isNumber());
        assertTrue(value.isInteger());
        assertEquals(intValue, value.asInt());
    }
}
