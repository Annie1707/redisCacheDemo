package com.poc.rediscache.controller;

import com.poc.rediscache.model.Student;
import com.poc.rediscache.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentService studentService;

    @PutMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        Student createResponse = studentService.save(student);
        return createResponse;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        LocalTime start = LocalTime.now();
        Student getReponse = studentService.get(id);
        LOG.info("time taken: {} milliseconds", start.until(LocalTime.now(), ChronoUnit.MILLIS));
        return getReponse;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody Student student) {
        studentService.delete(student);
        return "Record deleted succesfully";
    }
}
