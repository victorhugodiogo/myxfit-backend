package br.com.my.dominio.servico

import br.com.my.aplicacao.payload.AlunoRequest
import br.com.my.dominio.modelo.Aluno
import br.com.my.infraestrutura.repositorio.RepositorioAluno
import org.springframework.stereotype.Service

@Service
class ServicoAluno() {

    val repositorioAluno: RepositorioAluno = RepositorioAluno()

    fun criarAluno(alunoRequest: AlunoRequest): String {
        return repositorioAluno.salvar(
            Aluno(
                nome = alunoRequest.nome,
                cpf = alunoRequest.cpf
            )
        )
    }
}