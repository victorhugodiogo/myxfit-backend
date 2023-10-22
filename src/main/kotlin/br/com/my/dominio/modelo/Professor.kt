package br.com.my.dominio.modelo

class Professor : Usuario {
    var especialidade: String

    constructor(nome: String, cpf: String, especialidade: String) : super(nome, cpf) {
        this.especialidade = especialidade
    }

    override fun toString(): String = super.toString() + " - Especialidade [${especialidade}]"
}