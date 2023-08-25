package com.yuzarsif.studentmanagementsystem.mapper;

import com.yuzarsif.studentmanagementsystem.dto.StudentDto;
import com.yuzarsif.studentmanagementsystem.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student from) {
        return new StudentDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail());
    }

    public static Student mapToStudent(StudentDto from) {
        return new Student(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail());
    }
}
