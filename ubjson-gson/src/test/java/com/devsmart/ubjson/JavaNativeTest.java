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
        assertFalse(value.isFloat());
        assertTrue(value.isInteger());
        assertEquals(intValue, value.asInt());
    }

    @Test
    public void testConvertDouble() {
        final double fValue = 42.0;
        UBValue value = ObjectUtil.toUBValue(fValue);
        assertNotNull(value);
        assertTrue(value.isNumber());
        assertFalse(value.isInteger());
        assertTrue(value.isFloat());
        assertEquals(fValue, value.asInt(), 0.000001 );
    }
}
