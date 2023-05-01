package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
                this.students.put(student.getId(), student);

    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id

        return (Student)this.students.get(studentId);
        }


    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if have add the course to the student enrolledCourse
        Student student = this.findStudent(studentId);

        if(student != null) {
           student.enrollToCourse(course);
        }




    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses

        Iterator summary = this.students.entrySet().iterator();
        while(summary.hasNext()){
            Map.Entry<String, Student> entry = (Map.Entry)summary.next();
            System.out.println((String)entry.getKey());
            System.out.println(((Student)entry.getValue()).getName());
            System.out.println(String.valueOf(((Student)entry.getValue()).getEnrolledCourses().keySet()));
    }

    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses
        return student.getEnrolledCourses();



    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
       EnrolledCourse enrolledCourse =(EnrolledCourse)student.getEnrolledCourses().get(courseId);
       return enrolledCourse !=null ? enrolledCourse : null;
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
