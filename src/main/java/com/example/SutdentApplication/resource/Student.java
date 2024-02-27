package com.example.SutdentApplication.resource;

import com.example.SutdentApplication.model.StudentModel;
import com.example.SutdentApplication.service.StudentService;
import com.example.SutdentApplication.service.UniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class Student {
    
    @Autowired
    private StudentService studentService;
    private UniversityService universityService;

    @GetMapping("/get/{id}")
    public StudentModel getStudent(@PathVariable String id) throws Exception {
        return studentService.getStudent(id);
    }

    @PostMapping("/create/{name}/{age}/{uniId}")
    public String createStudent(@PathVariable String name, @PathVariable String age, @RequestParam String uniId) {
        StudentModel model = studentService.createStudent(name, age);
        universityService.addStudent(uniId, model);
        return model.id;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id) throws Exception {
        studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}/{name}/{age}")
    public StudentModel updateStudent(@PathVariable String id , @PathVariable String name,
                                            @PathVariable String age) throws Exception {
        return  studentService.updateStudent(id, name, age);
    }

    
}