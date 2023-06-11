package sk.husarmario.learn2code;

import org.junit.Test;

import static org.junit.Assert.*;

public class NamesUtilTest {

    @Test
    public void IsMarioName(){
        assertEquals("Mario Husar",NamesUtil.CREATOR);
    }

}