package org.example.baseballgame.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game123, testGame;

    @BeforeEach
    void setup(){
        testGame = new Game();
        game123 = new Game(Arrays.asList(1,2,3));
    }
    @Test
    void checkComputer() {
        Balls computerBalls = testGame.getComputer();

        assertTrue((0 < computerBalls.getBallList().get(0).getValue()) && (computerBalls.getBallList().get(0).getValue()) < 10);
        assertTrue((0 < computerBalls.getBallList().get(1).getValue()) && (computerBalls.getBallList().get(1).getValue()) < 10);
        assertTrue((0 < computerBalls.getBallList().get(2).getValue()) && (computerBalls.getBallList().get(2).getValue()) < 10);
    }

    @Test
    void checkPlayer() {
        testGame.setPlayer(Arrays.asList(1,2,3));
        Balls playerBalls = testGame.getPlayer();

        assertTrue((0 < playerBalls.getBallList().get(0).getValue()) && (playerBalls.getBallList().get(0).getValue()) < 10);
        assertTrue((0 < playerBalls.getBallList().get(1).getValue()) && (playerBalls.getBallList().get(1).getValue()) < 10);
        assertTrue((0 < playerBalls.getBallList().get(2).getValue()) && (playerBalls.getBallList().get(2).getValue()) < 10);
    }

    @Test
    void 판정_3스트라이크() {
        game123.setPlayer(Arrays.asList(1,2,3));
        game123.makeDecision();

        Map<Decision, Integer> decisions = game123.getResult();



        assertTrue(decisions.get(Decision.STRIKE) == 3);
    }

    @Test
    void 판정_1스트라이크_2볼() {
        game123.setPlayer(Arrays.asList(1,3,2));
        game123.makeDecision();

        Map<Decision, Integer> decisions = game123.getResult();


        assertTrue(decisions.get(Decision.STRIKE) == 1);
        assertTrue(decisions.get(Decision.BALL) == 2);
    }

    @Test
    void 판정_3볼() {
        game123.setPlayer(Arrays.asList(3,1,2));
        game123.makeDecision();

        Map<Decision, Integer> decisions = game123.getResult();

        assertTrue(decisions.get(Decision.STRIKE) == 0);
        assertTrue(decisions.get(Decision.BALL) == 3);
    }

    @Test
    void 판정_낫싱() {
        game123.setPlayer(Arrays.asList(4,5,6));
        game123.makeDecision();

        Map<Decision, Integer> decisions = game123.getResult();

        assertTrue(decisions.get(Decision.NOTHING) == 3);
    }
}