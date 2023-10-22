package br.com.my.dominio.modelo

import br.com.my.infraestrutura.repositorio.RepositorioAluno
import java.util.Objects

abstract class Usuario(
    var nome: String,
    var cpf: String
) {
    override fun toString(): String = "Nome[${nome}] - CPF[${cpf}]"
}