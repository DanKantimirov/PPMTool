package ru.kantimirov.ptool.service;

import org.springframework.stereotype.Service;
import ru.kantimirov.ptool.entity.database.ProjectDTO;
import ru.kantimirov.ptool.repository.ProjectRepository;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectDTO saveOrUpdateProjectMo(ProjectDTO projectDTO) {
        return this.projectRepository.save(projectDTO);
    }
}
