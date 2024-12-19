package org.example.baseballgame.step2;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private Balls computer;

    private Balls player;

    private List<Decision> decisions;

    private Map<Decision, Integer> result;

    public Game() {
        this.computer = makeComputer();
    }

    public Game(List<Integer> computer) {
        this.computer = new Balls(computer);
    }

    public Balls getComputer() {
        return computer;
    }

    public Balls getPlayer() {
        return player;
    }

    public Map<Decision, Integer> getResult() {
        return result;
    }

    private Balls makeComputer() {
        return new Balls(new Random().ints(3, 1, 10)
                .boxed()
                .collect(Collectors.toList()));
    }

    public void setPlayer(List<Integer> input) {
        player = new Balls(input);
    }

    public void makeDecision() {

        result = Arrays.stream(Decision.values())
                        .collect(Collectors.toMap(decision -> decision, decision -> 0));

        for (Ball playerBall : player.getBallList()) {
            boolean matched = false;

            for (Ball computerBall : computer.getBallList()) {
                Decision decision = computerBall.makeDecision(playerBall);
                if (decision != Decision.NOTHING) {
                    result.put(decision, result.getOrDefault(decision, 0) + 1);
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                result.put(Decision.NOTHING, result.get(Decision.NOTHING) + 1);
            }
        }
    }
}
