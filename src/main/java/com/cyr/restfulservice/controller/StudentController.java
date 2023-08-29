package com.cyr.restfulservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyr.restfulservice.dao.StudentDao;
import com.cyr.restfulservice.model.Student;
import com.cyr.restfulservice.service.StudentServiceImpl;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentservice;
	@Autowired
	private StudentDao repo;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "HelloWorld";
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(@RequestBody Student student) {
		System.out.println("controller...");
		if (student.getId() == 0) {
			studentservice.saveStudent(student);
		}
		return "Saved Successfully";
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Student>> listStudent() {
		return new ResponseEntity<List<Student>>(studentservice.getAllStudent(), HttpStatus.OK);
	}

	@GetMapping("/studentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {

		if (repo.findById(id).isPresent()) {
			return new ResponseEntity<Student>(studentservice.getStudent(id), HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteById(@PathVariable("id") int id) {
		if (repo.findById(id).isPresent()) {
			studentservice.deleteStudent(id);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		// studentservice.deleteStudent(id);
		// return "Deleted Successfully";
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable int id) {

		Optional<Student> studentOptional = repo.findById(id);

		if (studentOptional.isEmpty())
			return ResponseEntity.notFound().build();

		student.setId(id);

		studentservice.updateStudent(student);

		return ResponseEntity.noContent().build();
	}
}
