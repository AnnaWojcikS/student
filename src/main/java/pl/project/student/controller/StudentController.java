package pl.project.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.student.entity.Address;
import pl.project.student.entity.AddressType;
import pl.project.student.entity.Student;
import pl.project.student.service.AddressService;
import pl.project.student.service.StudentService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by A.Wójcik on 09.12.2019.
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private AddressService addressService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);

        return "list-students";
    }


    @GetMapping("/list/sort/id")
    public String sortStudentsById(Model model) {
        List<Student> students = studentService.sortById();
        model.addAttribute("students", students);
        Student student = new Student();
        model.addAttribute("student", student);

        return "list-students";
    }
    @GetMapping("/list/sort/firstName")
    public String sortStudentsByFirstName(Model model) {
        List<Student> students = studentService.sortByFirstName();
        model.addAttribute("students", students);
        Student student = new Student();
        model.addAttribute("student", student);

        return "list-students";
    }
    @GetMapping("/list/sort/secondName")
    public String sortStudentsBySecondName(Model model) {
        List<Student> students = studentService.sortBySecondName();
        model.addAttribute("students", students);
        Student student = new Student();
        model.addAttribute("student", student);

        return "list-students";
    }
    @GetMapping("/list/sort/lastName")
    public String sortStudentsByLastName(Model model) {
        List<Student> students = studentService.sortByLastName();
        model.addAttribute("students", students);
        Student student = new Student();
        model.addAttribute("student", student);

        return "list-students";
    }

    @GetMapping("/list/sort/pesel")
    public String sortStudentsByPesel(Model model) {
        List<Student> students = studentService.sortByPesel();
        model.addAttribute("students", students);
        Student student = new Student();
        model.addAttribute("student", student);

        return "list-students";
    }
    @GetMapping("/list/sort/dateOfBirth")
    public String sortStudentsByDateOfBirth(Model model) {
        List<Student> students = studentService.sortByDateOfBirth();
        model.addAttribute("students", students);
        Student student = new Student();
        model.addAttribute("student", student);

        return "list-students";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Student student = new Student();
        Address address = new Address();

        model.addAttribute("student", student);
        model.addAttribute("address", address);
        model.addAttribute("AddressTypes", Arrays.asList(AddressType.values()));
        return "student-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("AddressTypes", Arrays.asList(AddressType.values()));
        return "student-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") long id) {
        studentService.deleteById(id);
        return "redirect:/students/list";
    }


    @GetMapping("/list/search")
    public String searchStudents(@RequestParam("searchName") String searchName,
                                  Model theModel) {

        List<Student> students = studentService.searchStudents(searchName);
        theModel.addAttribute("students", students);

        return "list-students";

    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student) {

        studentService.save(student);


        return "redirect:/students/list";
    }

}
