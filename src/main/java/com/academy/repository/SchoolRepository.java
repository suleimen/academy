package com.academy.repository;

import com.academy.model.SchoolModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolModel, Long> {
}
