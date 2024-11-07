package com.es.repository

import com.es.model.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository: JpaRepository<Autor, Long> {


}