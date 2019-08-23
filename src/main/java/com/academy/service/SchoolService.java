package com.academy.service;

import com.academy.dto.ContactDTO;
import com.academy.dto.SchoolDTO;
import com.academy.model.ContactModel;
import com.academy.model.LanguageModel;
import com.academy.model.SchoolModel;
import com.academy.model.StudyTypeModel;
import com.academy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private StudyTypeRepository studyTypeRepository;

    public List<SchoolModel> getAllSchools(){
        return schoolRepository.findAll();
    }

    public Optional<SchoolModel> getSchoolById(Long id){
        return schoolRepository.findById(id);
    }

    public void addSchool(SchoolDTO schoolDto){
        SchoolModel school = saveSchool(schoolDto);
        saveContacts(school, schoolDto.getContacts());
    }

    private void saveContacts(SchoolModel school, Set<ContactDTO> contacts) {
        for (ContactDTO contact: contacts){
            ContactModel contactModel = new ContactModel();
            contactModel.setCity(cityRepository.findByName(contact.getCity()));
            contactModel.setAddress(contact.getAddress());
            contactModel.setLatitude(contact.getLatitude());
            contactModel.setLongitude(contact.getLongitude());
            contactModel.setPhoneNumbers(contact.getPhoneNumbers());
            contactModel.setMetro(contact.getMetro());
            contactModel.setSchool(school);
            contactRepository.save(contactModel);
        }
    }

    private SchoolModel saveSchool(SchoolDTO school){
        Set<LanguageModel> langs = new HashSet<>();
        Set<StudyTypeModel> studyTypes = new HashSet<>();
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setRating(school.getRating());
        schoolModel.setDescription(school.getDescription());
        schoolModel.setEmail(school.getEmail());
        schoolModel.setName(school.getName());
        school.getLanguages().stream().forEach(l->langs.add(languageRepository.findById(l).orElse(null)));
        school.getStudyTypes().stream().forEach(s->studyTypes.add(studyTypeRepository.findById(s).orElse(null)));
        schoolModel.setLanguages(langs);
        schoolModel.setStudyTypes(studyTypes);
        return schoolRepository.save(schoolModel);
    }
}
