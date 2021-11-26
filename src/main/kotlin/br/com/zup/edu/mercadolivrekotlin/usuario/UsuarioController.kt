package br.com.zup.edu.mercadolivrekotlin.usuario

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController {


    @PostMapping
    fun cadastrar() {
        
    }
}