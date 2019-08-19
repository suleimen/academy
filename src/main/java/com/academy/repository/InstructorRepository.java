package com.academy.repository;

import com.academy.model.InstructorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorModel, Long> {
}
