package com.code.SpringBoot_mysql.controller;

import com.code.SpringBoot_mysql.error.DepartmentNotFoundException;
import com.code.SpringBoot_mysql.model.Department;
import com.code.SpringBoot_mysql.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Value("${welcome.message}")
    private String welcmssg;

    @GetMapping("/welcome")
    public String Welcome()
    {
        return "Vivek s hegde";
    }

    @PostMapping("/insdepartments")
    public void saveDepartment(@Valid @RequestBody Department department)
    {
          departmentService.insertDepartment(department);

    }

   @GetMapping("/getdepartments")
    public List<Department> getDepartment() throws DepartmentNotFoundException
   {
       return departmentService.getdepartment();
   }

   @GetMapping("/Iddepartments/{id}")
    public Department IdDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

      return  departmentService.IdDepartment(departmentId);

   }

   @GetMapping("/Namedepartments/{name}")
   public Department Namedepartments(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {

      return departmentService.Namedepartments(departmentName);

   }

   @DeleteMapping("/Deletedepartments/{id}")
    public String Deletedepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

       return departmentService.Deletedepartment(departmentId);

   }


   @PutMapping("/Updatedepartments/{id}")
    public Department Updatedepartments(@PathVariable("id") Long departmentId,
                                    @RequestBody Department department) throws DepartmentNotFoundException {
       return  departmentService.Updatedepartments(departmentId,department);

   }

   @GetMapping("/search/{text}")
    public List<Department> SearchDepartment(@PathVariable("text") String text)
   {
       return departmentService.serachDeaprtment(text);
   }


}
