package com.poc.rediscache.service;

import com.poc.rediscache.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public Student save(Student student);

    public Student get(int id);

    public void delete(Student student);
}
