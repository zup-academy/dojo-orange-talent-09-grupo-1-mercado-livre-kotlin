package br.com.zup.edu.mercadolivrekotlin.usuario

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Usuario (
    val login: String,
    val senha: String,
        ){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val instante: LocalDateTime = LocalDateTime.now()
}