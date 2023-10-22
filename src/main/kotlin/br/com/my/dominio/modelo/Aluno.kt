package br.com.my.dominio.modelo

import java.util.UUID

class Aluno(
    val alunoId: String = UUID.randomUUID().toString(),
    nome: String,
    cpf: String
) : Usuario(
    nome = nome,
    cpf = cpf
) {
}