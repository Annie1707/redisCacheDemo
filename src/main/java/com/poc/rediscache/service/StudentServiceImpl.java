package com.poc.rediscache.service;

import com.poc.rediscache.model.Student;
import com.poc.rediscache.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("bookServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @CachePut(value = "student", key = "#student.id")
    public Student save(Student student) {
        Student createResponse = studentRepository.save(student);
        return createResponse;
    }

    @Transactional
    @Cacheable(value = "student", key = "#id")
    public Student get(int id) {
        Student student = null;
        Optional<Student> studentResponse = studentRepository.findById(id);
        if (studentResponse.isPresent()) {
            student = studentResponse.get();
        } else {
            throw new RuntimeException("Record not found");
        }
        return student;
    }

    @Transactional
    @CacheEvict(value = "student", key = "#student.id")
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
