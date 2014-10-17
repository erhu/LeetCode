package cn.erhu.leetcode;

import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-16
 * Time: 上午8:33
 */
public class ValidNumberTest {

    @Test
    public void isNumberTest() {
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("0"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(" 0.1 "), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("2e10"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(".1"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("5.1"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("01"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("3."), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("-1."), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("-01"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("+.8"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("40.81"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("46.e3"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(".2e81"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("1.431352e7"), true);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(" 005047e+6"), true);

        org.junit.Assert.assertEquals(new ValidNumber().isNumber("abc"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("1 a"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(".e1"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("96 e5"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(".."), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("..2"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("ee6"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("+ 8"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber("0.e"), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(" 4e3."), false);
        org.junit.Assert.assertEquals(new ValidNumber().isNumber(" 277707e26"), true);
    }
}
