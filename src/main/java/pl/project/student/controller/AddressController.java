package pl.project.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.project.student.dao.AddressRepository;
import pl.project.student.dao.StudentRepository;
import pl.project.student.entity.Address;
import pl.project.student.entity.Student;
import pl.project.student.service.AddressService;
import pl.project.student.service.StudentService;

import java.util.List;

/**
 * Created by A.Wójcik on 15.12.2019.
 */
@RequiredArgsConstructor
@Controller
public class AddressController {

    private AddressService addressService;
    private StudentService studentService;

    @Autowired
    public AddressController(AddressService addressService, StudentService studentService) {
        this.addressService = addressService;
        this.studentService = studentService;
    }
    @GetMapping("/addresses")
    public String listAllAddresses( Model model) {
        List<Address> addresses = addressService.findAll();
        model.addAttribute("addresses", addresses);
        return "addresses";
    }

    @GetMapping("/students/addresses")
    public String listAddresses(@RequestParam("studentId") long id, Model model) {
        Student student = studentService.findById(id);
        List<Address> addresses = student.getAddresses();
        Address address = new Address();
        addresses.add(address);
        model.addAttribute("student", student);
        model.addAttribute("addresses", addresses);
        model.addAttribute("address", address);

        return "list-addresses";
    }
//dotąd działa

    @PostMapping("/addresses/save")
    public String saveAddress(@ModelAttribute("address") Address address) {

        addressService.save(address);

        return "redirect:/students/list";
    }

   /* @GetMapping("/students/addresses/update")
    public String updateAddress(@RequestParam("addressId") long id, Model model) {
        Address address = addressService.findById(id);
        model.addAttribute("address", address);
        return "address-update";
    }*/

    @GetMapping("/students/addresses/delete")
    public String delete(@RequestParam("addressId") long id) {
        addressService.deleteById(id);
        return "redirect:/students/list";
    }
    @GetMapping("/showAddressForm")
    public String showForm(@RequestParam("studentId") long id, Model model) {
        Student student = studentService.findById(id);
        List<Address> addresses = student.getAddresses();
        int addressIndex;
        if (addresses == null) {
            addressIndex = 0;
        } else {
            addressIndex = addresses.size();
        }
        System.out.println(addressIndex);
        //addresses.add(new Address());

        model.addAttribute("student", student);
        model.addAttribute("index", addressIndex);
        return "address-form";

    }

}
