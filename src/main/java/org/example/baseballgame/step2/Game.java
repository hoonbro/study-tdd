package org.example.baseballgame.step2;

import java.util.Random;
import java.util.stream.Collectors;

public class Game {
    private final Balls computer;
    private Balls player;

    private int strike;
    private int ball;

    public Game() {
        this.computer = setComputer();
    }

    public Balls setComputer() {
        return new Balls(new Random().ints(3, 1, 10)
                .boxed()
                .collect(Collectors.toList()));
    }
}
