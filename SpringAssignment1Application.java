package com.example.springassignment1;

import java.util.Scanner;


public class SpringAssignment1Application {

    enum Courses {FOUNDATION, UNDERGRADUATE, HONOURS}

    ;

    public static void main(String[] args) {

        Courses studentCourses;

        String userEntry;



        Scanner input = new Scanner(System.in);

        System.out.println("The courses we offer are:");

        for (Courses c : Courses.values())

            System.out.print(c + " ");

        System.out.print("\n\nEnter your course >> ");

        userEntry = input.nextLine().toUpperCase();

        studentCourses = Courses.valueOf(userEntry);

        System.out.println("You entered " + studentCourses);

        switch (studentCourses) {

            case FOUNDATION:

                System.out.println("Elementary Computer Programming");

                System.out.println("Introduction to programming concept");

                break;

            case UNDERGRADUATE:

                System.out.println("Operating System ");

                System.out.println("Object Oriented Programming");

                System.out.println("introduction to Computer Networks");

                System.out.println("Software Engineering ");

                System.out.println("Computer Architecture Organisation");

                break;

            case HONOURS:

                System.out.println("Distribution and Parallel Computing ");

                System.out.println("Advanced Java");

                System.out.println("Intelligent Systems");

                System.out.println(" Computer Graphics");

                break;

            default:

                System.out.println("You entered a wrong entry");
        }
    }
}
