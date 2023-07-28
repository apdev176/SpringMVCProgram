package com.jsp.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.school.dto.Student;
import com.jsp.school.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/studentload")
	public ModelAndView studentLoad() {
		ModelAndView modelAndView = new ModelAndView("studentform.jsp");
		modelAndView.addObject("student1", new Student());
		return modelAndView;
	}

	@RequestMapping("/studentadd")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		Student s = studentService.saveStudent(student);
		modelAndView.addObject("saved", s.getName() + " saved successfully");
		return modelAndView;
	}

	@RequestMapping("/viewAllStudent")
	public ModelAndView viewAllStudents() {
		ModelAndView modelAndView = new ModelAndView("viewAllStudent.jsp");
		List<Student> students = studentService.viewAllStudents();
		modelAndView.addObject("students", students);
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteStudentById(@RequestParam(name = "id") int id) {
		studentService.deleteStudentById(id);

		ModelAndView modelAndView = new ModelAndView("deleted.jsp");
		modelAndView.addObject("deleted", "student with" + id + "deleted");
		return modelAndView;
	}
}
