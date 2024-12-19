package org.example.baseballgame.step2;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Balls {
    private final List<Ball> ballList;
    private final int SIZE = 3;

    public Balls(List<Integer> input){
        this.ballList = mapToBalls(input);
    }

    public List<Ball> mapToBalls(List<Integer> input) {
        List<Ball> inputBalls = new ArrayList<>();
        for(int i = 0; i < SIZE; i++){
            inputBalls.add(new Ball(i + 1, input.get(i)));
        }
        return inputBalls;
    }

    public Map<Decision, Integer> makeDecision(Balls inputBalls) {
        Map<Decision, Integer> decisionCount = new EnumMap<>(Decision.class);
        decisionCount.put(Decision.STRIKE, 0);
        decisionCount.put(Decision.BALL, 0);
        decisionCount.put(Decision.NOTHING, 0);

        for (Ball inputBall : inputBalls.ballList) {
            boolean matched = false;
            for (Ball ball : this.ballList) {
                Decision decision = ball.makeDecision(inputBall);
                if (decision != Decision.NOTHING) {
                    decisionCount.put(decision, decisionCount.get(decision) + 1);
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                decisionCount.put(Decision.NOTHING, decisionCount.get(Decision.NOTHING) + 1);
            }
        }

        return decisionCount;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Balls{ ballList= [");
        for(Ball ball : ballList){
            sb.append(ball.getValue()).append(" ");
        }
        sb.append("], SIZE=").append(SIZE).append("}");

        return sb.toString();
    }
}
