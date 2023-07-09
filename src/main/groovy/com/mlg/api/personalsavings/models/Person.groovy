package com.mlg.api.personalsavings.models

import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Canonical
@Document
class Person implements Serializable {

    private static final long serialVersionUID = 5679559985036104027L

    @Id
    String id
    String name
    String lastName
}
