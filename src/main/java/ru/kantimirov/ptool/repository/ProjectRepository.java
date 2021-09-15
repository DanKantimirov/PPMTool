package ru.kantimirov.ptool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kantimirov.ptool.entity.database.ProjectMO;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectMO, Long> {

}
