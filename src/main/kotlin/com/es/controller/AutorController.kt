package com.es.controller

import com.es.model.Autor
import com.es.services.AutorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/autores")

class AutorController {

    /*
    Maneja las solicitudes HTTP y comunicarse con el service
     */
    @Autowired
    private lateinit var autorService: AutorService

    @PostMapping("/")
    fun insertAutor(
        @RequestBody autor: Autor
    ): Autor? {
        return autorService.insertAutor(autor)
    }



    @GetMapping("/{id}")
    fun getById(
        @PathVariable
        id: String?
    ): Autor? {
        //1º Comprobar de forma basica los parametros
        if(id.isNullOrEmpty()){
            return null
        }
        return autorService.getById(id)
    }

}