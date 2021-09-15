package ru.kantimirov.ptool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kantimirov.ptool.entity.database.ProjectDTO;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectDTO, Long> {

}
