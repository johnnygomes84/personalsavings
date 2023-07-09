package com.mlg.api.personalsavings.service

import com.mlg.api.personalsavings.models.Person
import com.mlg.api.personalsavings.models.SearchContext
import com.mlg.api.personalsavings.repository.PersonRepository
import groovy.transform.TupleConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
@TupleConstructor(includeFields = true, defaults = false)
class PersonService {

    private final PersonRepository personRepository

    Person createPerson(Person person) {
        personRepository.save(person)
    }

    Page<Person> findAll(SearchContext searchContext) {
        personRepository.findAll(PageRequest.of(searchContext.page, searchContext.size))
    }
}
