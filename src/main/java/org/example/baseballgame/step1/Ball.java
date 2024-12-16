package org.example.baseballgame.step1;

import java.util.Objects;
import java.util.Random;

public class Ball implements Comparable<Ball>{
    private int value;

    public Ball(){
        value = new Random().nextInt(9) + 1;
    }

    public Ball(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;

        if(!(o instanceof Ball))
            return false;

        Ball ball = (Ball) o;

        return ball.value == this.value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Ball o) {
        return this.value - o.value;
    }
}
