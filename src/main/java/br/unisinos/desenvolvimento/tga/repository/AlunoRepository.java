package br.unisinos.desenvolvimento.tga.repository;

import org.springframework.data.repository.CrudRepository;

import br.unisinos.desenvolvimento.tga.entity.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

    Iterable<Aluno> findByNomeIgnoreCaseContaining(final String nome);

}
