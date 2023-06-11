package sk.mario.husar.learn2code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamesUtilTest {

    @Test
    public void isCreatorMe(){
        assertEquals("Mario Husar",NamesUtil.CREATOR);
    }

}