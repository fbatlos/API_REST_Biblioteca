package com.es.controller

import com.es.model.Autor
import com.es.model.Libro
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

    @GetMapping("/")
    fun getAllAutors():List<Autor>{
        return autorService.getAllAutors()
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

    @PutMapping("/")
    fun updateAutor(
        @RequestBody autor: Autor
    ):Autor?{
        return autorService.updateAutor(autor)
    }


    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable
        id: String?
    ):Boolean{
        if(id.isNullOrEmpty()){
            return false
        }
        return autorService.deleteAutor(id)
    }

    @GetMapping("/{id}/libros")
    fun getLibrosFromAutor(
        @PathVariable("id") id:String
    ):List<Libro>?{
        //1º Comprobar de forma basica los parametros
        if(id.isNullOrEmpty()){
            return null
        }
        return autorService.getLibrosFromAutor(id)
    }



}