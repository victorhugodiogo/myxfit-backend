package br.com.myxfit.dominio.modelo

abstract class Usuario(
    var nome: String,
    var cpf: String
) {
    override fun toString(): String = "Nome[${nome}] - CPF[${cpf}]"
}