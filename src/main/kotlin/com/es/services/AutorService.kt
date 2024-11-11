package com.es.services

import com.es.model.Autor
import com.es.model.Libro
import com.es.repository.AutorRepository
import com.es.utils.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class AutorService {
    @Autowired
    private lateinit var autorRepository: AutorRepository

    /*
    Controla la logica de negocio

     */

    fun insertAutor(autor: Autor): Autor? {
        //Recorrer para ver
        autor.libros.forEach { it.autor = autor }
        autorRepository.save(autor)
        return autor
    }

    fun getAllAutors(): List<Autor> {
        return autorRepository.findAll()
    }


    fun getById(id:String) : Autor?{
        //1º La logica.
        val idL:Long = if (Utils.checkId(id) != null) id.toLong() else return null

        //2º comunicacion con repository
        val autor:Autor = autorRepository.findByIdOrNull(idL)?: return null
        return autor
    }

    fun updateAutor(autor: Autor): Autor? {
        val autorExistente = autorRepository.findByIdOrNull(autor.id)?: return null

        autorExistente.nombre = autor.nombre
        autorExistente.nacionalidad = autor.nacionalidad
        autorExistente.anioNacimiento = autor.anioNacimiento
        autorExistente.biografia = autor.biografia
        autorExistente.libros = autor.libros
        autorExistente.libros.forEach { it.autor = autorExistente }

        return autorRepository.save(autorExistente)
    }

    fun deleteAutor(id:String): Boolean {
        val idL:Long = if (Utils.checkId(id) != null) id.toLong() else return false
        autorRepository.findByIdOrNull(idL)?: return false

        autorRepository.deleteById(idL)
        return true
    }

    fun getLibrosFromAutor(id: String): List<Libro>? {
        val idL:Long = if (Utils.checkId(id) != null) id.toLong() else return null
        val autor:Autor = autorRepository.findByIdOrNull(idL) ?: return null
        return autor.libros
    }


}