package ru.kantimirov.ptool.service;

import org.springframework.stereotype.Service;
import ru.kantimirov.ptool.entity.database.ProjectDTO;
import ru.kantimirov.ptool.exception.InnerLogicRuntimeException;
import ru.kantimirov.ptool.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectDTO createProject(ProjectDTO projectDTO) {
        try {
            return this.projectRepository.save(projectDTO);
        } catch (Exception e) {
            throw new InnerLogicRuntimeException(e.getMessage());
        }
    }

    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        try {
            if (projectDTO.getIdentifier() == null) {
                throw new InnerLogicRuntimeException("Can not find a project by identifier:" + projectDTO.getIdentifier());
            }
            Optional<ProjectDTO> optionalProjectDTO = this.projectRepository.findByIdentifier(projectDTO.getIdentifier());
            if (!optionalProjectDTO.isPresent()) {
                throw new InnerLogicRuntimeException("Can not find a project by identifier:" + projectDTO.getIdentifier());
            }
            return this.projectRepository.save(projectDTO);
        } catch (Exception e) {
            throw new InnerLogicRuntimeException(e.getMessage());
        }
    }

    public Optional<ProjectDTO> findByIdentifier(String identifier) {
        return this.projectRepository.findByIdentifier(identifier);
    }

    public List<ProjectDTO> findAll() {
        return this.projectRepository.findAll();
    }

    public Boolean deleteProjectByIdentifier(String identifier) {
        Optional<ProjectDTO> optionalProjectDTO = this.findByIdentifier(identifier);
        if (!optionalProjectDTO.isPresent()) {
            throw new InnerLogicRuntimeException("Can not find a project with identifier:" + identifier);
        }
        this.projectRepository.delete(optionalProjectDTO.get());
        return true;
    }
}
