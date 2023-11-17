package com.mlg.api.personalsavings.models

import groovy.transform.Canonical
import groovyjarjarantlr4.v4.runtime.misc.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Canonical
@Document
class Person implements Serializable {

    private static final long serialVersionUID = 5679559985036104027L

    @Id
    @NotNull
    String id
    @NotNull
    String name
    @NotNull
    String lastName
}
