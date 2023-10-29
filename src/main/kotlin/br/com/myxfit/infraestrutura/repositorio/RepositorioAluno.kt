package br.com.myxfit.infraestrutura.repositorio

import br.com.my.infraestrutura.jooq.persistence.tables.references.ALUNO
import br.com.myxfit.dominio.modelo.Aluno
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class RepositorioAluno(
    private val jooq: DSLContext
) {
    fun listarAlunos(): List<Aluno> =
        jooq.select()
            .from(ALUNO)
            .fetchInto(Aluno::class.java)

    fun salvar(aluno: Aluno): Aluno =
        jooq.insertInto(
            ALUNO,
            ALUNO.NOME,
            ALUNO.DOCUMENTO,
            ALUNO.MATRICULA
        ).values(
            aluno.nome,
            aluno.documento,
            aluno.matricula
        ).returningResult()
            .fetchOneInto(Aluno::class.java)!!


    fun alteraNome(alunoId: Long, nome: String) =
        jooq.update(ALUNO)
            .set(ALUNO.NOME, nome)
            .where(ALUNO.ID.eq(alunoId))
            .execute() > 0
}