package br.com.myxfit.dominio.servico

import br.com.myxfit.aplicacao.payload.AlunoRequest
import br.com.myxfit.dominio.exception.RecursoNoContentException
import br.com.myxfit.dominio.modelo.Aluno
import br.com.myxfit.dominio.util.GeradorMatricula
import br.com.myxfit.infraestrutura.repositorio.RepositorioAluno
import org.springframework.stereotype.Service
import java.util.Random
import java.util.UUID

@Service
class ServicoAluno(private val repositorioAluno: RepositorioAluno) {
    fun listarAlunos(): List<Aluno> =
        repositorioAluno.listarAlunos()
            .takeIf { it.isNotEmpty() }
            ?: throw RecursoNoContentException()

    fun criarAluno(alunoRequest: AlunoRequest): Aluno {
        return repositorioAluno.salvar(
            Aluno(
                nome = alunoRequest.nome,
                documento = alunoRequest.documento,
                matricula = GeradorMatricula.generate()
            )
        )
    }
}