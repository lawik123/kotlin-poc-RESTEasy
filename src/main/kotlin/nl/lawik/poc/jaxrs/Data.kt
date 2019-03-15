package nl.lawik.poc.jaxrs

import nl.lawik.poc.jaxrs.entity.Person

object Data {
    private var idSequence = 3
    private val persons = mutableListOf(Person(1, "test", 20), Person(2, "test2", 21))

    fun findById(id: Int): Person? {
        return persons.firstOrNull { it.id == id }
    }

    fun findAll(): List<Person> {
        return persons
    }

    fun insert(person: Person): Int? {
        return if (person.id === null) {
            val newId = idSequence++
            persons.add(person.copy(id = newId))
            newId
        } else {
            null
        }
    }

    fun update(person: Person): Boolean {
        val savedPerson = persons.firstOrNull { it.id == person.id }
        return if (savedPerson == null) {
            false
        } else {
            persons.remove(savedPerson)
            persons.add(person)
            true
        }
    }

    fun delete(id: Int): Boolean {
        val person: Person? = findById(id)
        return if (person == null) {
            false
        } else {
            persons.remove(person)
            true
        }
    }
}