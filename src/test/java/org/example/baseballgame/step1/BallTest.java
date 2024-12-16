package org.example.baseballgame.step1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

class BallTest {

    @Test
    void getValue() {
        Ball ball = new Ball(5);

        assertTrue(ball.getValue() == new Ball(5).getValue());
        assertFalse(ball.getValue() == new Ball(6).getValue());
        assertTrue(0 < new Ball().getValue() && new Ball().getValue() < 10);
    }

    @Test
    void testEquals() {
        assertTrue(new Ball(5).equals(new Ball(5)));
    }

    @Test
    void testHashCode() {
        HashMap<Ball, Integer> map = new HashMap<>();

        map.put(new Ball(5), 1);
        map.put(new Ball(5), 1);

        assertTrue(map.size()==1);
    }
}