package com.example.springassignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CourseApplication{

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

    @RestController
    public static class CourseController {

        @GetMapping("/courses")
        public List<String> getCourses() {
            List<String> foundationCourses = Arrays.asList("Foundations of Computer Science I", "Foundations of Computer Science II");
            List<String> undergraduateCourses = Arrays.asList("Data Structures and Algorithms", "Computer Networks", "Operating Systems", "Database Systems", "Software Engineering");
            List<String> honoursCourses = Arrays.asList("Advanced Algorithms", "Artificial Intelligence", "Computer Graphics", "Parallel and Distributed Computing");

            StringBuilder response = new StringBuilder();
            response.append("Foundation courses:\n");
            for (String course : foundationCourses) {
                response.append("- ").append(course).append("\n");
            }

            response.append("\nUndergraduate courses:\n");
            for (String course : undergraduateCourses) {
                response.append("- ").append(course).append("\n");
            }

            response.append("\nHonours courses:\n");
            for (String course : honoursCourses) {
                response.append("- ").append(course).append("\n");
            }

            return Arrays.asList(response.toString());
        }
    }
}
