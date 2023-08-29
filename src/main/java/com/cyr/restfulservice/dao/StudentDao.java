package com.cyr.restfulservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyr.restfulservice.model.Student;


@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}
