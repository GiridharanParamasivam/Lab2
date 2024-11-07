package com.example.COMP367; // Make sure this matches your package name

import java.time.LocalTime;

public class main {
    public static void main(String[] args) {
        String name = "Giridharan Paramasivam"; // Replace with your actual name
        LocalTime currentTime = LocalTime.now();
        String greeting;

        // Determine the greeting based on the time of day
        if (currentTime.getHour() < 12) {
            greeting = "Good morning, " + name + ", Welcome to COMP367";
        } else {
            greeting = "Good afternoon, " + name + ", Welcome to COMP367";
        }

        // Output the greeting
        System.out.println(greeting);
    }
}
