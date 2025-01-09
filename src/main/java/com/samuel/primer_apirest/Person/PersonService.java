package com.samuel.primer_apirest.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

//el servicio provee los metodos al controlador para el controlador

@Service
@RequiredArgsConstructor//crea el constructor requerido 
public class PersonService{

    //Final se utiliza para definir un atributo que no se va a poder cambiar luego de la incializacion
    private final PersonRepository personRepo; //inyecto dependencias

    public void createPerson(Person person){
        personRepo.save(person); //sirve como create
    }
}
