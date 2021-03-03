package com.nfangbian.javasupport;

import com.nfangbian.javasupport.utils.StringUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        System.out.println(StringUtils.toStringIgnoreNull(new String("hello")));

        System.out.println(StringUtils.boolean2String(true));
        System.out.println(StringUtils.string2Boolean("0"));

    }
}
