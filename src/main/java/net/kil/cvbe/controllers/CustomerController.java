/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.controllers;

import net.kil.cvbe.data.entity.Customer;
import net.kil.cvbe.repositories.CustomerRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerRepository repository;

    private final CustomerResourceAssembler assembler;

    public CustomerController(CustomerRepository repository,
                              CustomerResourceAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/")
    public Resources<Resource<Customer>> all() {

        List<Resource<Customer>> customer = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(customer,
                linkTo(methodOn(CustomerController.class).all()).withSelfRel());
    }
}
