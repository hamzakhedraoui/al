package com.elearning.teacher.controllers;

import com.elearning.teacher.models.Teacher;
import com.elearning.teacher.models.TeacherList;
import com.elearning.teacher.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursController {


    private TeacherService service;
    @Autowired
    public CoursController(TeacherService service){
        this.service = service;
    }
    @RequestMapping("/")
    public TeacherList AllModules() {
        List<Teacher> listTeachers = service.listAll();
        TeacherList teacherList = new TeacherList();
        teacherList.setTeachersList(listTeachers);
        return teacherList;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public TeacherList saveProduct(@RequestBody Teacher teacher) {
        service.save(teacher);
        List<Teacher> listTeacher = service.listAll();
        TeacherList teacherList = new TeacherList();
        teacherList.setTeachersList(listTeacher);
        return teacherList;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "";
    }
    @RequestMapping("/{id}")
    public Teacher deleteProduct(@PathVariable(name = "id") long id) {
        Teacher teacher = service.get(id);
        return teacher;
    }
}
