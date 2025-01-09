package com.samuel.primer_apirest.Person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.primer_apirest.exceptions.PersonNotFoundException;

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

    /*En caso de que el programa pueda devolver un estado 200 (ok) nulo cuando no encuentre resultados
    @GetMapping("/{id}")
    public Person findPerson(@PathVariable Integer id){
        return personService.findPersonById(id);
    } */

    //En caso de que se desee retornar un 404 (Not found)
    @GetMapping("/{id}")
    public ResponseEntity<Person> findPerson(@PathVariable Integer id) {
        Person person = personService.findPersonById(id);
            if (person == null) {
                return ResponseEntity.notFound().build();
            }
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id){ //no puedo retornar un 200, ya que no tengo contenido y puede ser confuso para el usuario.
        try {
            personService.deletePersonById(id);
            return ResponseEntity.noContent().build();//retorna un 204 diciendo que se borro, pero sin contenido 
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();//retorna un 404 porque no encontro algun recurso
        }
         
    }
}
