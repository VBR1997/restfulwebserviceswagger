package com.cyr.restfulservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyr.restfulservice.dao.StudentDao;
import com.cyr.restfulservice.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentdao;

	@Override
	public Student saveStudent(Student student) {
		studentdao.save(student);
		return student;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		return studentdao.findAll();
	}

	@Override
	public Student getStudent(int stuid) {
		return studentdao.getById(stuid);
	}

	@Override
	@Transactional
	  public void deleteStudent(int Id) {
	      studentdao.deleteById(Id);
}
	@Override
	@Transactional
	public Student updateStudent(Student student) {
		 return studentdao.save(student);
	}
}
