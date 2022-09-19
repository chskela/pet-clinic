package com.chskela.petclinic.services.springdatajpa

import com.chskela.petclinic.model.Visit
import com.chskela.petclinic.repositories.VisitRepository
import com.chskela.petclinic.services.VisitService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("springdatajpa")
class VisitSDJpaService(private val visitRepository: VisitRepository) : VisitService {
    override fun findAll(): Set<Visit> {
        return visitRepository.findAll().toSet()
    }

    override fun findById(id: Long): Visit {
        return visitRepository.findById(id).orElse(Visit.notFound())
    }

    override fun save(entity: Visit): Visit {
        return visitRepository.save(entity)
    }

    override fun delete(entity: Visit) {
        visitRepository.delete(entity)
    }

    override fun deleteById(id: Long) {
        visitRepository.deleteById(id)
    }
}