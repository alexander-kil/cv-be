/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.controllers;

import net.kil.cvbe.data.entity.Customer;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
class CustomerResourceAssembler implements ResourceAssembler<Customer, Resource<Customer>> {

    @Override
    public Resource<Customer> toResource(Customer customer) {
        return new Resource<>(customer,
                linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).all()).withRel("customers"));
    }
}
