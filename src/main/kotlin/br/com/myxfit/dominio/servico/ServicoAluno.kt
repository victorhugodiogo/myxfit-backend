package br.com.myxfit.dominio.servico

import br.com.myxfit.aplicacao.payload.AlunoRequest
import br.com.myxfit.dominio.modelo.Aluno
import br.com.myxfit.infraestrutura.repositorio.RepositorioAluno
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