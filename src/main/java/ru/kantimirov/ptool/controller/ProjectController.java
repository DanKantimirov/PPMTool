package ru.kantimirov.ptool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kantimirov.ptool.entity.database.ProjectDTO;
import ru.kantimirov.ptool.exception.InnerLogicRuntimeException;
import ru.kantimirov.ptool.service.ProjectService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/project/")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectDTO projectDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        ProjectDTO projectSaved = this.projectService.createProject(projectDTO);
        return new ResponseEntity<>(projectSaved, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> updateProject(@Valid @RequestBody ProjectDTO projectDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        ProjectDTO projectSaved = this.projectService.updateProject(projectDTO);
        return new ResponseEntity<>(projectSaved, HttpStatus.OK);
    }

    @GetMapping(value = "{identifier}")
    public ResponseEntity<?> findByIdentifier(@PathVariable("identifier") String identifier) {
        Optional<ProjectDTO> optionalProject = this.projectService.findByIdentifier(identifier);
        if (optionalProject.isEmpty()) {
            throw new InnerLogicRuntimeException("Can not find a project with identifier: " + identifier);
        }
        return new ResponseEntity<>(optionalProject.get(), HttpStatus.OK);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(this.projectService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "{identifier}")
    public ResponseEntity<?> deleteByIdentifier(@PathVariable("identifier") String identifier) {
        Boolean result = this.projectService.deleteProjectByIdentifier(identifier);
        if (result) {
            return new ResponseEntity<>("The project:" + identifier + " was deleted", HttpStatus.OK);
        } else {
            throw new InnerLogicRuntimeException("Can not delete a project with identifier: " + identifier);
        }
    }

}
