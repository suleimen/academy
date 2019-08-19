package com.academy.service;

import com.academy.model.InstructorModel;
import com.academy.model.UserModel;
import com.academy.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<InstructorModel> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public void addInstructor(InstructorModel instructorModel){
        instructorRepository.save(instructorModel);
    }
}
