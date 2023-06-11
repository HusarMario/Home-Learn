package sk.mario.husar.learn2code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreServiceTest {

    CoreService coreService = new CoreService();

    @Test
    public void checkAfterGottenName(){
        assertEquals(NamesUtil.CREATOR,coreService.giveCreatorName());
    }
}

