package com.academy.controllers;

import com.academy.dto.SchoolDTO;
import com.academy.model.LocationModel;
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

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addSchool(@RequestBody SchoolDTO school){

        Map<String, String> map = new HashMap<>();
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setRating(school.getRating());
        schoolModel.setDescription(school.getDescription());
        schoolModel.setEmail(school.getEmail());
        schoolModel.setName(school.getName());
        schoolModel.setPhoneNumber(school.getPhoneNumber());
        LocationModel locationModel = new LocationModel();
        locationModel.setLatitude(school.getLatitude());
        locationModel.setLongitude(school.getLongitude());
        schoolModel.setLocation(locationModel);
        schoolService.addSchool(schoolModel);
        map.put("res", "ok");
        return map;
    }

}
