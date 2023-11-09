package com.example.iasfslot6sem4.controller;

import com.example.iasfslot6sem4.entity.Students;
import com.example.iasfslot6sem4.repository.StudentRepository;
import com.example.iasfslot6sem4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class studentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/liststudent")
    public String getListStudent(ModelMap modelMap){
        String view = "student/listStudent";
        try {
            List<Students> students = studentService.findbyStudent();
            modelMap.addAttribute("students", students);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

    //Nut add Student
    @GetMapping("/getFormCreate")
    public String getFormCreate(ModelMap modelMap){
        String view = "student/create";
        try {
            Students student = new Students();
            modelMap.addAttribute("student", student);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

    //Nut Create
    @PostMapping("/create")
    public String saveCreate(@ModelAttribute("student") Students student, ModelMap modelMap){
        String view = "redirect:/student/liststudent";
        try {
            studentService.saveStudent(student);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }

    //Nut edit
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getFormUpdate(@PathVariable("id") Integer id , ModelMap modelMap){
        String view = "student/update";
        try {
            modelMap.addAttribute("student", studentService.findbyIdStudent(id));// student này sẽ đại diện dữ liêu trang view hiển thị vd customer.id
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }

    //Nut update
    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute("student") Students student, ModelMap modelMap){
        String view = "redirect:/student/liststudent";
        try {
            studentService.saveStudent(student);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id , ModelMap modelMap){
        String view = "redirect:/student/liststudent";
        try {
            studentService.deleteStudentById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }






}
