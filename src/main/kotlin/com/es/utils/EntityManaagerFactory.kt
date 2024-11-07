package com.es.utils

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

object EntityManagerFactory {
    val emf = Persistence.createEntityManagerFactory("libreria_bd")
    fun createManager(): EntityManager {

        return emf.createEntityManager()
    }
}