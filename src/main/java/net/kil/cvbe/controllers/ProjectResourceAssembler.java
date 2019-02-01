/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.controllers;

import net.kil.cvbe.data.entity.Project;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
class ProjectResourceAssembler implements ResourceAssembler<Project, Resource<Project>> {

	@Override
	public Resource<Project> toResource(Project project) {

		return new Resource<>(project,
			linkTo(methodOn(ProjectController.class).one(project.getId())).withSelfRel(),
			linkTo(methodOn(ProjectController.class).all()).withRel("projects")
		);
	}
}
