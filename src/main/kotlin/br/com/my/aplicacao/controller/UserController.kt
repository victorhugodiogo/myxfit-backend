package br.com.my.aplicacao.controller

import br.com.my.aplicacao.payload.UserResponseDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/")
    fun getAlunos(): List<UserResponseDTO> {
        return listOf(UserResponseDTO("Andriele", "mx-00000001", "Hipertrofia"))
    }

}