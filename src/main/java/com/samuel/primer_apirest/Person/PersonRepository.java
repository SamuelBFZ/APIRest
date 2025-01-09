package com.samuel.primer_apirest.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Al heredar de JpaRepository adquiero automaticamente un conjunto de metodos CRUD
public interface PersonRepository extends JpaRepository <Person, Integer>{

}