package com.samuel.primer_apirest.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //genera getters y setter, ademas de toString, hashCode y equals 
@AllArgsConstructor //crea constructor con todos los parametros
@NoArgsConstructor //crea constructor sin parametros
@Entity//crea en la BD
public class Person {
    @Id //define que el id es un id
    @GeneratedValue //como se genera el valor
    private Integer id;
    @Basic
    private String firstname;
    private String lastname;
    private String email;
}