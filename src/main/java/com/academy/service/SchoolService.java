package com.academy.service;

import com.academy.dto.AddressDTO;
import com.academy.dto.SchoolDTO;
import com.academy.model.AddressModel;
import com.academy.model.LanguageModel;
import com.academy.model.SchoolModel;
import com.academy.repository.AddressRepository;
import com.academy.repository.CityRepository;
import com.academy.repository.LanguageRepository;
import com.academy.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public List<SchoolModel> getAllSchools(){
        return schoolRepository.findAll();
    }

    public void addSchool(SchoolDTO schoolDto){
        SchoolModel school = saveSchool(schoolDto);
        saveAddresses(school, schoolDto.getAddresses());
    }

    private void saveAddresses(SchoolModel school, Set<AddressDTO> addresses) {
        for (AddressDTO address: addresses){
            AddressModel addressModel = new AddressModel();
            addressModel.setCity(cityRepository.findByName(address.getCity()));
            addressModel.setStreetName(address.getStreetName());
            addressModel.setStreetNumber(address.getStreetNumber());
            addressModel.setUnit(address.getUnit());
            addressModel.setLatitude(address.getLatitude());
            addressModel.setLongitude(address.getLongitude());
            addressModel.setSchool(school);
            addressRepository.save(addressModel);
        }
    }

    private SchoolModel saveSchool(SchoolDTO school){
        List<LanguageModel> langs = new ArrayList<>();
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setRating(school.getRating());
        schoolModel.setDescription(school.getDescription());
        schoolModel.setEmail(school.getEmail());
        schoolModel.setName(school.getName());
        schoolModel.setPhoneNumbers(school.getPhoneNumbers());
        school.getLanguages().stream().forEach(l->langs.add(languageRepository.findById(l).orElse(null)));
        schoolModel.setLanguages(langs);
        return schoolRepository.save(schoolModel);
    }
}
