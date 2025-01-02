package org.example.junit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Assert {
    public Assert(){

    }

    public void assertEquals(Object o1, Object o2){
        if(!o1.equals(o2)){
            log.info("test FAILED");
            log.info("expect < " + o1 + "> but was " + o2 + ">");
            throw new AssertionError("expect < " + o1 + "> but was " + o2 + ">");
        }

        log.info("test PASSED");
    }

}
