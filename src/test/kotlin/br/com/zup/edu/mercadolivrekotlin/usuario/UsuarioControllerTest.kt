package br.com.zup.edu.mercadolivrekotlin.usuario

import com.google.gson.Gson
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class UsuarioControllerTest {

    val uri = "/usuarios"

    @Autowired
    lateinit var mock: MockMvc

    @Autowired
    lateinit var gson: Gson

    @Test
    fun deveCadastrarUmNovoUsuarioQuandoAsInformacoesSaoValidasERetornarStatus200() {
        val usuarioRequest = UsuarioRequest("natacha.amigona@gmail.com", "123456")

        mock.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(gson.toJson(usuarioRequest)))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @ParameterizedTest
    @ValueSource(strings = ["igor.amigaoemail.com", "igor@.com"])
    fun deveRetornarStatus400QuandoUmUsuarioTiverEmailInvalido(email: String) {
        val usuarioRequest = UsuarioRequest(email, "123456")

        mock.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(gson.toJson(usuarioRequest)))
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun deveRetornarStatus400QuandoUmUsuarioTiverSenhaInferiorA6Caracteres() {
        val usuarioRequest = UsuarioRequest("carlos.amigao@email.com", "12345")

        mock.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(gson.toJson(usuarioRequest)))
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun deveRetornarStatus400QuandoUmUsuarioTiverEmailVazio() {
        val usuarioRequest = UsuarioRequest("", "123456")

        mock.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON).content(gson.toJson(usuarioRequest)))
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }


//    fun `Não deve aceitar login nulo e assim retornar status 400 ` () {
//        val usuarioRequest = UsuarioRequest(null, "123456")
//
//        mock.perform(MockMvcRequestBuilders.post(uri)
//            .contentType(MediaType.APPLICATION_JSON).content(gson.toJson(usuarioRequest)))
//            .andExpect(MockMvcResultMatchers.status().isBadRequest)
//    }
}

