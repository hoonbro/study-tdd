package org.example.baseballgame.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    private Balls computer;

    @BeforeEach
    void setup(){
        computer = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    void 판정_1스트라이크_2볼() {
        Balls player = new Balls(Arrays.asList(1,3,2));

        Map<Decision, Integer> decisions = computer.makeDecision(player);

        assertTrue(decisions.get(Decision.STRIKE) == 1);
        assertTrue(decisions.get(Decision.BALL) == 2);
    }

    @Test
    void 판정_2스트라이크() {
        Balls player = new Balls(Arrays.asList(1,2,4));

        Map<Decision, Integer> decisions = computer.makeDecision(player);

        assertTrue(decisions.get(Decision.STRIKE) == 2);
    }

    @Test
    void 판정_3볼() {
        Balls player = new Balls(Arrays.asList(3,1,2));

        Map<Decision, Integer> decisions = computer.makeDecision(player);

        assertTrue(decisions.get(Decision.STRIKE) == 0);
        assertTrue(decisions.get(Decision.BALL) == 3);
    }

    @Test
    void 판정_낫싱() {
        Balls player = new Balls(Arrays.asList(4,5,6));

        Map<Decision, Integer> decisions = computer.makeDecision(player);

        assertTrue(decisions.get(Decision.STRIKE) == 0);
        assertTrue(decisions.get(Decision.BALL) == 0);
        assertTrue(decisions.get(Decision.NOTHING) == 3);
    }
}