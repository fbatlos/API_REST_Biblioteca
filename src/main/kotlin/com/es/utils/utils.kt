package com.es.utils

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

object Utils {

    fun checkId(id:String):Long?{
        val idL:Long?
        try {
            idL = id.toLong()
        }catch (e: Exception){
            println(e.message)
            return null
        }
        return idL
    }


}