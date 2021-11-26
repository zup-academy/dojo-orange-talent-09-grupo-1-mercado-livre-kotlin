package br.com.zup.edu.mercadolivrekotlin.usuario

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRespository : CrudRepository<Usuario, Long>{
}