package br.com.myxfit.aplicacao.controller

import br.com.myxfit.aplicacao.payload.AlunoRequest
import br.com.myxfit.aplicacao.payload.AlunoResponse
import br.com.myxfit.aplicacao.payload.asResponse
import br.com.myxfit.dominio.servico.ServicoAluno
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/alunos")
class AlunoController(private val servicoAluno: ServicoAluno) {
    @GetMapping
    fun getAlunos(): ResponseEntity<List<AlunoResponse>> {
        return ResponseEntity.ok(
            servicoAluno.listarAlunos()
                .map { it.asResponse(it) })
    }

    @PostMapping
    fun criarAluno(@RequestBody alunoRequst: AlunoRequest): ResponseEntity<AlunoResponse> {
        return ResponseEntity.ok(servicoAluno.criarAluno(alunoRequst)
            .let { aluno -> aluno.asResponse(aluno) })
    }

}