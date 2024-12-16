package org.example.baseballgame.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        while(true){
            System.out.println("숫자 야구 게임을 시작하시겠습니까?(Y/N)");

            String flag = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if(flag.equals("N"))
                break;

            System.out.println("숫자 야구 시작");
            gameStart();
        }

        System.out.println("숫자 야구 종료");
    }

    public static void gameStart() throws IOException {
        List<Ball> computerBalls = new ArrayList<>();

        //create computer's ball list
        for(int i = 0; i < 3; i++){
            computerBalls.add(new Ball());
        }

        BufferedReader br;

        while(true){

            //user input
            System.out.println("숫자를 입력하세요");
            br = new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();

            List<Ball> inputBalls = new ArrayList<>();

            //cast to ball List
            for(int i = 0; i < s.length(); i++){
                inputBalls.add(new Ball(s.charAt(i) - '0'));
            }

            Collections.sort(computerBalls);
            Collections.sort(inputBalls);

            int strike = 0;
            int ball = 0;

            for(int i = 0; i < 3; i++){
                System.out.print(computerBalls.get(i).getValue());
            }
            System.out.println();

            for(int i = 0; i < 3; i++){
                System.out.print(inputBalls.get(i).getValue());
            }
            System.out.println();

            for(int i = 0, j = 0; i < s.length() && j < s.length();){
                System.out.println(i + " " + j);
                if(computerBalls.get(i).equals(inputBalls.get(j))) {
                    strike++;
                    i++;
                    j++;
                    continue;
                }

                ball++;
                if(computerBalls.get(i).getValue() > inputBalls.get(j).getValue())
                    j++;
                else i++;
            }

            if(strike == 3){
                System.out.println("정답입니다.");
                break;
            }else if(strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }else{
                System.out.println(ball + "볼 " + strike +" 스트라이크");
            }
        }
    }
}