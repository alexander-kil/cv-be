/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe;

import lombok.extern.slf4j.Slf4j;
import net.kil.cvbe.data.AcademicDegreeType;
import net.kil.cvbe.data.entity.*;
import net.kil.cvbe.repositories.CustomerRepository;
import net.kil.cvbe.repositories.EmployeeRepository;
import net.kil.cvbe.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository,
                                   ProjectRepository projectRepository, CustomerRepository customerRepository) {
        return args -> {
            Employee empp1 = employeeRepository.save(new Employee("Pedro", "Alvares", "developer", AcademicDegreeType.UNDEFINED, null));
            employeeRepository.save(new Employee("Pablo", "Alcobar", "VSOP tester", AcademicDegreeType.MASTER, "Ancient Alkos"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            Customer cust_1 = new Customer("Microsoft", "the big one Company");
            customerRepository.save(cust_1);
            Customer cust_2 = new Customer("Google", "another big Company");
            customerRepository.save(cust_2);

            customerRepository.findAll().forEach(c -> log.info("Preloaded " + c));

            projectRepository.save(Project.builder().
                    name("Project 1").
                    description("Some project 1").
                    customer(cust_1).
                    months(10).
                    member(Member.builder().
                            employee(empp1).
                            skill(UsedSkill.builder().
                                    name("Basic").build()).
                            build()).
                    build());
            projectRepository.save(Project.builder().
                    name("Project 2").
                    description("Some project 2").
                    customer(cust_2).
                    months(2).
                    member(Member.builder().employee(empp1).build()).
                    build());

            projectRepository.findAll().forEach(project -> log.info("Preloaded " + project));
        };
    }
}
