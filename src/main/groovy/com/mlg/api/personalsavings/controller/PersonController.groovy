package com.mlg.api.personalsavings.controller

import com.mlg.api.personalsavings.models.Person
import com.mlg.api.personalsavings.models.SearchContext
import com.mlg.api.personalsavings.service.PersonService
import groovy.transform.TupleConstructor
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
@TupleConstructor(includeFields = true, defaults = false)
@RequestMapping("/api/person")
class PersonController {

    private final PersonService personService

    @GetMapping("/all")
    ResponseEntity<Page<Person>> findAll(SearchContext searchContext) {
        ResponseEntity.ok(personService.findAll(searchContext))
    }

    @PostMapping("/new")
    ResponseEntity<Person> create(@RequestBody Person person) {
        ResponseEntity.ok(personService.createOrUpdate(person))
    }

    @PutMapping("/update")
    ResponseEntity<Person> update(@RequestBody Person person) {
        ResponseEntity.ok(personService.createOrUpdate(person))
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deletePerson(@PathVariable String id) {
        if(!id) {
            ResponseEntity.badRequest().body("Person Id is null or empty")
        }
        ResponseEntity.ok(personService.deletePerson(id))
    }

    @GetMapping("/{id}")
    ResponseEntity<Person> findById(@PathVariable String id) {
        ResponseEntity.ok(personService.findById(id))
    }
}
