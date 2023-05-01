package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;


public class Student extends Person {
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);

    }

    public boolean enrollToCourse(Course course) {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        EnrolledCourse enrolledCourse = new EnrolledCourse(course);
        if (this.enrolledCourses.containsKey(course.getCode())) {

            return false;
        } else {
            this.enrolledCourses.put(course.getCode(), enrolledCourse);
            return true;
        }
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses() {
        //TODO return a Hashmap of all the enrolledCourses
        return this.enrolledCourses;

    }

    public void gradeCourse(String courseCode, double grade) {
        //TODO set the grade for the enrolled Course
        //this.enrolledCourses.get(courseCode).setGrade(grade)

        if (!this.enrolledCourses.containsKey(courseCode)) {
            System.out.println("Student is not enrolled in this course.");
        } else {
            EnrolledCourse enrolledCourse = (EnrolledCourse) this.enrolledCourses.get(courseCode);
            enrolledCourse.setGrade(grade);
            System.out.println(grade);
        }
    }


    public Course findCourseById(String courseId) {
        //TODO return a Course from the course Id - loop enrolled courses hash map
        //enrolledcourse object.getcode()
        Course course = null;
        Iterator enroll = this.enrolledCourses.values().iterator();

        while (enroll.hasNext()) {
            EnrolledCourse enrolledCourse = (EnrolledCourse) enroll.next();
            if (enrolledCourse.getCode().equals(courseId)) {
                course = enrolledCourse;
                break;
            }
        }
        return course;
        }


        public HashMap<String, EnrolledCourse> findPassedCourses () {
            //TODO Check the enrolled courses grade and compare to the passing grade
            HashMap<String, EnrolledCourse> passCourses = new HashMap();
            Iterator pass = this.enrolledCourses.values().iterator();

            while (pass.hasNext()) {

                EnrolledCourse enrolledCourse = (EnrolledCourse) pass.next();
                if (enrolledCourse.getGrade() >= 3.0) {
                    passCourses.put(enrolledCourse.getCode(), enrolledCourse);
                }
            }
            return passCourses;
        }
        public String toString ()
        {
            return "Student {" + super.toString() + "}";
        }
}

