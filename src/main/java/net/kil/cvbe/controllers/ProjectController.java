/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.controllers;

import net.kil.cvbe.data.entity.Project;
import net.kil.cvbe.exceptions.ProjectNotFoundException;
import net.kil.cvbe.repositories.ProjectRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectResourceAssembler assembler;

    public ProjectController(ProjectRepository projectRepository,
                             ProjectResourceAssembler assembler) {

        this.projectRepository = projectRepository;
        this.assembler = assembler;
    }

    @GetMapping("/")
    public Resources<Resource<Project>> all() {

        List<Resource<Project>> projects = projectRepository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(projects,
                linkTo(methodOn(ProjectController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public Resource<Project> one(@PathVariable Long id) {
        return assembler.toResource(
                projectRepository.findById(id)
                        .orElseThrow(() -> new ProjectNotFoundException(id)));
    }

    @PostMapping("/")
    public ResponseEntity<Resource<Project>> newOrder(@RequestBody Project project) {

        Project newProject = projectRepository.save(project);

        return ResponseEntity
                .created(linkTo(methodOn(ProjectController.class).one(newProject.getId())).toUri())
                .body(assembler.toResource(newProject));
    }
}
