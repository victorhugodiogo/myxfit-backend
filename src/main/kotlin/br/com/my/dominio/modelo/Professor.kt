package br.com.my.dominio.modelo

import br.com.my.infraestrutura.repositorio.RepositorioUsuario
import java.util.*

class Professor : Usuario {
    var especialidade: String

    constructor(nome: String, cpf: String, especialidade: String) : super(nome, cpf) {
        this.especialidade = especialidade
    }

    override val paginaInicial: String get() = "/home/professor/alunos"
    override fun toString(): String = super.toString() + " - Especialidade [${especialidade}]"
}