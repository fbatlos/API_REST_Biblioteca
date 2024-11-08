package com.es.model

import com.es.model.Autor
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date

@Entity
@Table(name="libros")
data class Libro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var titulo: String,

    var genero: String,

    @Column(name = "anio_publicacion")
    var anioPublicacion: Int,

    var precio: Double,

    @ManyToOne(fetch = FetchType.LAZY,cascade = [CascadeType.MERGE])
    @JoinColumn(name = "autor_id")
    @JsonBackReference
    var autor: Autor?
)