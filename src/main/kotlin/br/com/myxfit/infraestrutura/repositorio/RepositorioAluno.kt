package br.com.myxfit.infraestrutura.repositorio

import br.com.myxfit.dominio.modelo.Aluno

class RepositorioAluno(val bdAluno : MutableMap<String,Aluno> = mutableMapOf()) {

    fun salvar(aluno: Aluno) : String {
        var message : String
        if(bdAluno.contains(aluno.cpf)){
            message = "Aluno já cadastrado!"
            println(message)
            return message
        }

        bdAluno.put(aluno.cpf, aluno)
        message = "Aluno salvo com sucesso! $aluno"
        println(message)
        return message

    }
}