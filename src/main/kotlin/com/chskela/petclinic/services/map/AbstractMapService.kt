package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.BaseEntity
import java.util.Collections

abstract class AbstractMapService<T : BaseEntity> {

    private var map: MutableMap<Long, T> = mutableMapOf()

    fun findAll(): Set<T> = map.values.toSet()

    fun findById(id: Long): T? = map[id]

    open fun save(entity: T): T {
        if (entity.id == null) {
            entity.id = getNextId()
        }

        entity.id?.let {
            map[it] = entity
        }

        return entity
    }

    fun delete(entity: T) {
        map.entries.removeIf { entry -> entry.value == entity }
    }

    fun deleteById(id: Long) {
        map.remove(id)
    }

    private fun getNextId(): Long = if (map.isEmpty()) {
        0
    } else {
        Collections.max(map.keys)
    } + 1
}