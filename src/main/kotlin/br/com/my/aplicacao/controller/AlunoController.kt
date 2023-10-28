package br.com.my.aplicacao.controller

import br.com.my.aplicacao.payload.AlunoRequest
import br.com.my.aplicacao.payload.AlunoResponse
import br.com.my.dominio.servico.ServicoAluno
import br.com.my.infraestrutura.repositorio.RepositorioAluno
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