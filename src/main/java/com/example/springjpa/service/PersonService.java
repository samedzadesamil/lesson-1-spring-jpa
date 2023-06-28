package com.example.springjpa.service;

import com.example.springjpa.dto.DetailsPerson;
import com.example.springjpa.dto.FullNamePerson;
import com.example.springjpa.entitiy.Person;
import com.example.springjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    public FullNamePerson getPersonById(Long id) {
        Person person = personRepository.getPersonById(id);
        return FullNamePerson
                .builder()
                .name(person.getName())
                .surname(person.getSurname())
                .build();
    }

    public String addPerson(Person person) {
        if(personWrongDataControl(person)){
            return "giris bilgilerinde sehv var";
        }
        Person person1 = personRepository.save(person);
        if (person1 != null) {
            return person1.getName() + ": adinda istifadeci elave olundu";
        } else {
            return "istifadeci elave olunmadi ";
        }
    }

    public String deletePerson(long id) {
        if (personRepository.existsById(id)) {
            String name = getPersonById(id).getName();
            personRepository.deleteById(id);
            Person person = personRepository.findById(id).orElse(null);
            if (person == null) {
                return name + ": adinda istifadeci silindi";
            }
            return "istifadeci silinmedi";
        } else {
            return "verilen ID deyerinde istifadeci movcud deyl";
        }
    }

    public List<FullNamePerson> getPersonList() {
        List<Person> personList = personRepository.findAll();
        List<FullNamePerson> outPersonList = new ArrayList<>();
        for (Person p : personList) {
            outPersonList.add(FullNamePerson
                    .builder()
                    .name(p.getName())
                    .surname(p.getSurname())
                    .build());
        }
        return outPersonList;
    }

    public List<DetailsPerson> getPersonListDetail() {
        List<Person> personList = personRepository.findAll();
        List<DetailsPerson> outPersonList = new ArrayList<>();
        for (Person p : personList) {
            outPersonList.add(DetailsPerson
                    .builder()
                    .name(p.getName())
                    .surname(p.getSurname())
                    .email(p.getEmail())
                    .location(p.getLocation())
                    .build());
        }
        return outPersonList;
    }

    public boolean personWrongDataControl(Person person) {
        if (
                        person.getName() != null &&
                        person.getSurname() != null &&
                        person.getEmail() != null &&
                        person.getLocation() != null
        ) {
            return false;
        } else {
            return true;
        }
    }
}


