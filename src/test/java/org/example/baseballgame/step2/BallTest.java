package org.example.baseballgame.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    
    private Ball computer;

    @BeforeEach
    void setup(){
        computer = new Ball(1, 4);
    }
    
    @Test
    void getValue() {
        Ball ball = new Ball(1,5);

        assertTrue(ball.getValue() == new Ball(1,5).getValue());
        assertFalse(ball.getValue() == new Ball(1,6).getValue());
    }

    @Test
    void testEquals() {
        assertTrue(new Ball(1,5).equals(new Ball(1,5)));
    }

    @Test
    void testHashCode() {
        HashMap<Ball, Integer> map = new HashMap<>();

        map.put(new Ball(1,5), 1);
        map.put(new Ball(1,5), 1);

        assertTrue(map.size()==1);
    }

    @Test
    void strikePitchingTest(){
        Ball pitching = new Ball(1, 4);
        Decision decision = pitching.makeDecision(computer);

        assertTrue(decision.equals(Decision.STRIKE));
    }

    @Test
    void ballPitchingTest(){
        Ball pitching = new Ball(2, 4);
        Decision decision = pitching.makeDecision(computer);

        assertTrue(decision.equals(Decision.BALL));
    }

    @Test
    void notingPitchingTest(){
        Ball pitching = new Ball(2, 5);
        Decision decision = pitching.makeDecision(computer);

        assertTrue(decision.equals(Decision.NOTHING));
    }
}