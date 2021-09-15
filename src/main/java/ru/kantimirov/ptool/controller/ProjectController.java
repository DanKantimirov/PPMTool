package ru.kantimirov.ptool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kantimirov.ptool.entity.database.ProjectMO;
import ru.kantimirov.ptool.service.ProjectService;

@RestController
@RequestMapping(path = "/api/project/")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ProjectMO> createNewProject(@RequestBody ProjectMO projectMO) {
        ProjectMO projectSaved = this.projectService.saveOrUpdateProjectMo(projectMO);
        return new ResponseEntity<>(projectSaved, HttpStatus.CREATED);
    }

}
