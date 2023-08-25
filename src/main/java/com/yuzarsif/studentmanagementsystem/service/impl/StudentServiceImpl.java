package com.yuzarsif.studentmanagementsystem.service.impl;

import com.yuzarsif.studentmanagementsystem.dto.StudentDto;
import com.yuzarsif.studentmanagementsystem.entity.Student;
import com.yuzarsif.studentmanagementsystem.mapper.StudentMapper;
import com.yuzarsif.studentmanagementsystem.repository.StudentRepository;
import com.yuzarsif.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = repository.findAll();

        List<StudentDto> studentDtoList = students.stream()
                .map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());

        return studentDtoList;
    }

    @Override
    public void createStudent(StudentDto student) {
        Student mapToStudent = StudentMapper.mapToStudent(student);
        repository.save(mapToStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = repository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        repository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        repository.deleteById(studentId);
    }
}
