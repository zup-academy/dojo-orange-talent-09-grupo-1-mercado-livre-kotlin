package br.com.zup.edu.mercadolivrekotlin.usuario

import com.sun.istack.NotNull
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Usuario (
    @Column(nullable = false)
    val login: String,
    @Column(nullable = false)
    var senha: String,
        ){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val instante: LocalDateTime = LocalDateTime.now()
}