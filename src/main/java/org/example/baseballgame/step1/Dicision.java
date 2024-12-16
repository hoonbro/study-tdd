package org.example.baseballgame.step1;

public enum Dicision {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    Dicision(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
