package com.code.SpringBoot_mysql.service;

import com.code.SpringBoot_mysql.model.Department;
import com.code.SpringBoot_mysql.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    public DepartmentService departmentService;

    @Autowired
    public Department department;


    @MockBean
    public DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        department.setDepartmentId(1L);
        department.setDepartmentCode("C01");
        department.setDepartmentName("CS");
        department.setDepartmentAddress("Bengaluru");

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CS"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Checking department name is matching or not")
    public void departmentFindByNameTest()
    {

         department =departmentService.Namedepartments("CS");

        assertEquals("CS",department.getDepartmentName());

    }
}