package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kate Ingraham
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Person {
    private double height;
    private double weight;

    public double getHeight() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter your height in inches: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid height.");
                System.out.println("Enter your height in inches: ");
            }
            height = input.nextDouble();
            if (height < 0) {
                System.out.println("Height cannot be a negative value.");
            }
        } while (height < 0);
        return height;
    }

    public double getWeight() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter your weight in pounds: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid weight.");
                System.out.println("Enter your weight in pounds: ");
            }
            weight = input.nextDouble();
            if (weight < 0) {
                System.out.println("Weight cannot be a negative value.");
            }
        } while (weight < 0);
        return weight;
    }

    public void calcBMI(){
        height = getHeight();
        weight = getWeight();
        double step1 = height * height;
        double step2 = weight / step1;
        double bmi = step2 * 703;
        BigDecimal roundBMI = BigDecimal.valueOf(bmi);
        roundBMI = roundBMI.setScale(2, RoundingMode.HALF_UP);
        bmi = roundBMI.doubleValue();

        System.out.println("Your BMI is "+bmi+".");

        if(bmi < 18.5){
            System.out.println("You are underweight. You should see your doctor.");
        } else if(bmi > 25){
            System.out.println("You are overweight. You should see your doctor.");
        }else{
            System.out.println("You are within the ideal weight range.");
        }

    }
}
