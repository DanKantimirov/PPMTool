package ru.kantimirov.ptool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kantimirov.ptool.entity.database.ProjectDTO;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectDTO, Long> {
    Optional<ProjectDTO> findByIdentifier(String identifier);
}
