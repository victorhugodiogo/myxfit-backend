package br.com.myxfit.dominio.modelo

class Aluno(
    val id: Long? = null,
    nome: String,
    documento: String,
    val matricula: String
) : Usuario(
    nome = nome,
    documento = documento
) {
}