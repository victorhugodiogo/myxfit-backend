package br.com.my.infraestrutura.repositorio

import br.com.my.dominio.modelo.Aluno
import br.com.my.dominio.modelo.Professor
import br.com.my.dominio.modelo.Usuario

class RepositorioUsuario {
    fun salvar(usuario: Usuario){
        println( usuario )
    }
}