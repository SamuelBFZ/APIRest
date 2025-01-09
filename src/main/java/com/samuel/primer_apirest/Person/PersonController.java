package com.samuel.primer_apirest.Person;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")//Ruta del controlador
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public void createPerson(@RequestBody Person person){ //Request body es que me lo retorna en el cuerpo del mensaje del request 
        personService.createPerson(person);
    }
}
