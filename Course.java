package com.example.springassignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
class SpringAssignment2{

    private static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

    @RestController
    @RequestMapping("/courses")
    @Validated
    public static class CourseController {

        @GetMapping
        public List<Course> getAllCourses() {
            return courses;
        }

        @PostMapping
        public ResponseEntity<String> createCourse(@RequestBody Course course) {
            courses.add(course);
            return ResponseEntity.status(HttpStatus.CREATED).body("Course created successfully");
        }

        @PutMapping("/{id}")
        public ResponseEntity<String> updateCourse(@PathVariable("id") int id, @RequestBody Course course) {
            if (id < 0 || id >= courses.size()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
            }
            courses.set(id, course);
            return ResponseEntity.status(HttpStatus.OK).body("Course updated successfully");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteCourse(@PathVariable("id") int id) {
            if (id < 0 || id >= courses.size()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
            }
            courses.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
        }
    }

    public static class Course {
        private String name;

        public Course() {
        }

        public Course(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
