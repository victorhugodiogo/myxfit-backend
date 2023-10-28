package br.com.myxfit.aplicacao.controller

import br.com.myxfit.aplicacao.payload.AlunoRequest
import br.com.myxfit.aplicacao.payload.AlunoResponse
import br.com.myxfit.dominio.servico.ServicoAluno
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/alunos")
class AlunoController {

    private lateinit   var servicoAluno: ServicoAluno


    @GetMapping
    fun getAlunos(): List<AlunoResponse> {
        return listOf(AlunoResponse("Andriele", "mx-00000001", "Hipertrofia"))
    }

    @PostMapping
    fun criarAluno(alunoRequst: AlunoRequest): String {
        return servicoAluno.criarAluno(alunoRequst)
    }

}