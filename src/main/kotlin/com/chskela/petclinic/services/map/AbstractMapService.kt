package com.chskela.petclinic.services.map

abstract class AbstractMapService<T, ID> {

    private var map: MutableMap<ID, T> = mutableMapOf()

    fun findAll(): Set<T> = map.values.toSet()

    fun findById(id: ID): T? = map[id]

    fun save(id: ID, entity: T): T {
        map.plus(id to entity)
        return entity
    }

    fun delete(entity: T) {
        map.entries.removeIf { entry -> entry.value == entity }
    }

    fun deleteById(id: ID) {
        map.remove(id)
    }
}