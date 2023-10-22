package br.com.my.dominio.modelo

import br.com.my.infraestrutura.repositorio.RepositorioUsuario
import java.util.Objects

abstract class Usuario(
    var nome: String,
    var cpf: String
) {
    var repositorioUsuario: RepositorioUsuario = RepositorioUsuario()
    open val paginaInicial: String get() = "/home/sobre"

    fun atualizarUsuario(nome: String, cpf: String) {
        if (Objects.nonNull(nome))
            this.nome = nome;
        if (Objects.nonNull(cpf))
            this.cpf = cpf;
        repositorioUsuario.salvar(this)
    }
    override fun toString(): String = "Nome[${nome}] - CPF[${cpf}]"
}