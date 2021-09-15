package ru.kantimirov.ptool.service;

import org.springframework.stereotype.Service;
import ru.kantimirov.ptool.entity.database.ProjectMO;
import ru.kantimirov.ptool.repository.ProjectRepository;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectMO saveOrUpdateProjectMo(ProjectMO projectMO) {
        return this.projectRepository.save(projectMO);
    }
}
