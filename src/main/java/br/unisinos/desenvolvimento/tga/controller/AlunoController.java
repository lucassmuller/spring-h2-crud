package br.unisinos.desenvolvimento.tga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unisinos.desenvolvimento.tga.entity.Aluno;
import br.unisinos.desenvolvimento.tga.service.AlunoService;
import jdk.nashorn.internal.objects.annotations.Getter;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public Iterable<Aluno> findAll() {
        return alunoService.findAll();
    }

    @GetMapping(path = "/search")
    public Iterable<Aluno> search(@RequestParam(name = "s") final String term) {
        return alunoService.search(term);
    }

    @GetMapping(path = "/{matricula}")
    public Aluno findById(@PathVariable(name = "matricula") final Long matricula) {
        return alunoService.findById(matricula);
    }

    @PostMapping
    private Aluno create(@RequestBody final Aluno aluno) {
        return alunoService.create(aluno);
    }

    @PutMapping(path = "/{matricula}")
    private Aluno update(@PathVariable(name = "matricula") final Long matricula,
        @RequestBody final Aluno aluno) {
        return alunoService.update(matricula, aluno);
    }

    @DeleteMapping(path = "/{matricula}")
    private Aluno delete(@PathVariable(name = "matricula") final Long matricula) {
        return alunoService.remove(matricula);
    }

}
