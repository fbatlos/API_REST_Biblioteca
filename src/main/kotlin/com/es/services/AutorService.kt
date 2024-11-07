package com.es.services

import com.es.model.Autor
import com.es.repository.AutorRepository
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


    fun getById(id:String) : Autor?{

        //1º La logica.
        val idL:Long?
        try {
             idL = id.toLongOrNull()
        }catch (e: Exception){
            println(e.message)
            return null
        }
        //2º comunicacion con repository

        val autor:Autor? = autorRepository.findByIdOrNull(idL)

        return autor

    }


}