package org.example.junit;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private int totalCnt;
    private int passedCnt;
    private int failedCnt;
    private List<String> failedDetails;

    public TestResult() {
        totalCnt = 0;
        passedCnt = 0;
        failedCnt = 0;
        failedDetails = new ArrayList<>();
    }

    public void incrementTotalCnt(){
        totalCnt++;
    }

    public void incrementPassedCnt(){
        passedCnt++;
    }

    public void incrementFailedCnt(){
        failedCnt++;
    }

    public void addFailedDetails(String detail){
        failedDetails.add(detail);
    }

    public void printDetails (){
        System.out.println("---------------Test Results------------------");
        System.out.printf("%-15s: %d%n", "Total Tests", totalCnt);
        System.out.printf("%-15s: %d%n", "Passed Tests", passedCnt);
        System.out.printf("%-15s: %d%n", "Failed Tests", failedCnt);

        if(failedDetails.size() > 0){
            System.out.println("\nFailed Tests Details : ");

            for (int i = 0; i < failedDetails.size(); i++) {
                System.out.printf("  %d. %s%n", i + 1, failedDetails.get(i));
            }
        }

        System.out.println("--------------------------------------------");
    }
}
