package com.devsmart.ubjson;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        assertEquals(fValue, value.asFloat64(), 0.000001 );
    }

    @Test
    public void testConvertList() {
        final List<?> list = Arrays.asList( 1, 2, 3, 42.0, false, "Hello!");
        UBValue value = ObjectUtil.toUBValue(list);
        assertNotNull(value);
        assertTrue(value.isArray());
        final List<UBValue> result = value.asArray().asList();
        assertEquals( list.size(), result.size());
        assertEquals(list.get(0), result.get(0).asInt());
        assertEquals(list.get(1), result.get(1).asInt());
        assertEquals(list.get(2), result.get(2).asInt());
        assertEquals((Double) list.get(3), result.get(3).asFloat64(), 0.0000001);
        assertEquals(list.get(4), result.get(4).asBool());
        assertEquals(list.get(5), result.get(5).asString());
    }
}
