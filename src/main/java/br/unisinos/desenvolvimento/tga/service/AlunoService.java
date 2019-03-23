package br.unisinos.desenvolvimento.tga.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisinos.desenvolvimento.tga.entity.Aluno;
import br.unisinos.desenvolvimento.tga.exception.BadRequestException;
import br.unisinos.desenvolvimento.tga.exception.NotFoundException;
import br.unisinos.desenvolvimento.tga.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Iterable<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Iterable<Aluno> search(final String term) {
        return alunoRepository.findByNomeIgnoreCaseContaining(term);
    }

    public Aluno findById(final Long matricula) {
        return alunoRepository.findById(matricula)
            .orElseThrow(() -> new NotFoundException("Aluno com matricula %s não encontrado", matricula));
    }

    public Aluno create(final Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(final Long matricula, final Aluno alunoUpdated) {
        final Aluno aluno = findById(matricula);

        Optional.ofNullable(alunoUpdated.getNome())
            .ifPresent(aluno::setNome);

        Optional.ofNullable(alunoUpdated.getDataNascimento())
            .ifPresent(aluno::setDataNascimento);

        alunoRepository.save(aluno);

        return aluno;
    }

    public Aluno remove(final Long matricula) {
        final Aluno aluno = findById(matricula);

        alunoRepository.delete(aluno);

        return aluno;
    }

}
