package com.academy.controllers;

import com.academy.dto.InstructorDTO;
import com.academy.model.InstructorModel;
import com.academy.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InstructorModel> getAllIstructors(){
        return instructorService.getAllInstructors();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> addInstructor(@RequestBody InstructorDTO instructor){
        Map<String, String> map = new HashMap<>();
        InstructorModel model = new InstructorModel();
        model.setFirstName(instructor.getFirstName());
        model.setLastName(instructor.getLastName());
        model.setRating(instructor.getRating());
        model.setAge(instructor.getAge());
        model.setGender(instructor.getGender());
        instructorService.addInstructor(model);
        map.put("res", "ok");
        return map;
    }

}
