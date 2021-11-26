package br.com.zup.edu.mercadolivrekotlin.usuario

import org.springframework.security.crypto.bcrypt.BCrypt
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UsuarioRequest(
    @field:NotBlank @field:Email val login: String,
    @field:NotBlank @field:Size(min = 6) val senha: String
) {

    fun paraUsuario() = Usuario(login, BCrypt.hashpw(senha, BCrypt.gensalt()))

}