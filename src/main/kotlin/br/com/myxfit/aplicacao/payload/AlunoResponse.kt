package br.com.myxfit.aplicacao.payload

import br.com.myxfit.dominio.modelo.Aluno

data class AlunoResponse(
    val id: Long?,
    val nome: String,
    val documento: String,
    val matricula: String
)

fun Aluno.asResponse(aluno: Aluno): AlunoResponse =
    AlunoResponse(
        aluno.id,
        aluno.nome,
        aluno.documento,
        aluno.matricula
    )