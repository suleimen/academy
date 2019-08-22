package com.academy.controllers;

import com.academy.dto.SchoolDTO;
import com.academy.model.AddressModel;
import com.academy.model.SchoolModel;
import com.academy.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping(value = "/find")
    public List<SchoolModel> getAllSchools(){
        return schoolService.getAllSchools();
    }

    @GetMapping(value = "/find/{id}")
    public SchoolModel getSchoolById(@PathVariable(value = "id")Long id){
        return schoolService.getSchoolById(id).get();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addSchool(@RequestBody SchoolDTO school){
        Map<String, String> map = new HashMap<>();
        schoolService.addSchool(school);
        map.put("res", "ok");
        return map;
    }

}
