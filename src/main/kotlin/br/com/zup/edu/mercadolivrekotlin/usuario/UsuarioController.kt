package br.com.zup.edu.mercadolivrekotlin.usuario

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/usuarios")
class UsuarioController(val usuarioRespository: UsuarioRespository) {


    @PostMapping
    fun cadastrar(@RequestBody @Valid request: UsuarioRequest) {

        val usuario = request.paraUsuario()
        usuarioRespository.save(usuario)
    }
}