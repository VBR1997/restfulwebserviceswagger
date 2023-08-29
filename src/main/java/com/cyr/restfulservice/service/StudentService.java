package com.cyr.restfulservice.service;

import java.util.List;

import com.cyr.restfulservice.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public Student getStudent(int studentid);

	public List<Student> getAllStudent();

	public void deleteStudent(int studentId);

	public Student updateStudent(Student student);

}
