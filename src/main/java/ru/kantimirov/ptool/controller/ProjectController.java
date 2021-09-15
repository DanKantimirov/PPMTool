package ru.kantimirov.ptool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kantimirov.ptool.entity.database.ProjectDTO;
import ru.kantimirov.ptool.service.ProjectService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/project/")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ProjectDTO> createNewProject(@Valid @RequestBody ProjectDTO projectDTO) {
        ProjectDTO projectSaved = this.projectService.saveOrUpdateProjectMo(projectDTO);
        return new ResponseEntity<>(projectSaved, HttpStatus.CREATED);
    }

}
