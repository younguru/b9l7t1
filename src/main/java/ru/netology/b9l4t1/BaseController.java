package ru.netology.b9l4t1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {
    @Autowired
    BaseRepository baseRepository;

    @GetMapping("/persons/by-city")
    public List getPersonByCity(@RequestParam(name = "city") String city) {
        return baseRepository.getPersonsByCity(city);
    }
}
