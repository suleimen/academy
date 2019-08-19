package com.academy.service;

import com.academy.model.SchoolModel;
import com.academy.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public void addSchool(SchoolModel schoolModel){
        schoolRepository.save(schoolModel);
    }

    public List<SchoolModel> getAllSchools(){
        return schoolRepository.findAll();
    }
}
