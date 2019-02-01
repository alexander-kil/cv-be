/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.controllers;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

    @GetMapping
    public ResourceSupport index() {
        ResourceSupport rootResource = new ResourceSupport();
        rootResource.add(ControllerLinkBuilder.linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
        rootResource.add(ControllerLinkBuilder.linkTo(methodOn(ProjectController.class).all()).withRel("projects"));
        rootResource.add(ControllerLinkBuilder.linkTo(methodOn(CustomerController.class).all()).withRel("customers"));
        return rootResource;
    }

}