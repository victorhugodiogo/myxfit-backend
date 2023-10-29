package br.com.myxfit.dominio.modelo

abstract class Usuario(
    var nome: String,
    var documento: String
) {
    override fun toString(): String = "Nome[${nome}] - CPF[${documento}]"
}