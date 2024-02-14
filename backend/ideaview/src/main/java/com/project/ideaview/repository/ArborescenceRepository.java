package com.project.ideaview.repository;

import com.project.ideaview.model.Arborescence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArborescenceRepository extends JpaRepository<Arborescence, Integer> {
}
