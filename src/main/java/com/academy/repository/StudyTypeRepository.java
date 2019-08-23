package com.academy.repository;

import com.academy.model.StudyTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTypeRepository extends JpaRepository<StudyTypeModel, Long> {
}
