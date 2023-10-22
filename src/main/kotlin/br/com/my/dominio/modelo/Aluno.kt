package br.com.my.dominio.modelo

import br.com.my.infraestrutura.repositorio.RepositorioUsuario
import java.util.*

class Aluno : Usuario {
    constructor(nome: String, cpf: String) : super(nome, cpf)
    override val paginaInicial: String get() = "/home/aluno"
}