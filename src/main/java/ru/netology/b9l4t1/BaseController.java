package ru.netology.b9l4t1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/persons")
public class BaseController {
    @Autowired
    BaseRepository baseRepository;

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam(name = "city") String city) {
        return baseRepository.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> getPersonByAge(@RequestParam(name = "age") Integer age) {
        return baseRepository.getPersonsByAge(age);
    }

    @GetMapping("/by-ns")
    public Optional<List<Person>> getPersonByNS(@RequestParam(name = "name") String name,
                                                @RequestParam(name = "surname") String surname) {
        return baseRepository.getPersonsByNS(name, surname);
    }

}
