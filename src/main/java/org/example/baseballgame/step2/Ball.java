package org.example.baseballgame.step2;

import java.util.Objects;

public class Ball implements Comparable<Ball>{
    private int order;
    private int value;

    public Ball(int order, int value){
        this.order = order;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Decision makeDecision(Ball ball){
        if(this.equals(ball))
            return Decision.STRIKE;

        if(this.value == ball.value)
            return Decision.BALL;

        return Decision.NOTHING;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;

        if(!(o instanceof Ball))
            return false;

        Ball ball = (Ball) o;

        return ball.order == this.order
                &&ball.value == this.value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(order, value);
    }

    @Override
    public int compareTo(Ball o) {
        return this.value - o.value;
    }
}
