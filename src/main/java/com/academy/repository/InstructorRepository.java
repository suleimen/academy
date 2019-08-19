package com.academy.repository;

import com.academy.model.InstructorModel;
import com.academy.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorModel, Long> {

    Optional<InstructorModel> findById(Long id);
}
