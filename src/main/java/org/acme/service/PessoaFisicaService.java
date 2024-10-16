package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.PessoaFisicaEntity;
import org.acme.exception.PessoaFisicaNotFindException;

import java.util.List;

@ApplicationScoped
public class PessoaFisicaService {

    public PessoaFisicaEntity postPessoaFisica(PessoaFisicaEntity pessoaFisicaEntity) {
        PessoaFisicaEntity.persist(pessoaFisicaEntity);
        return pessoaFisicaEntity;
    }

    public List<PessoaFisicaEntity> findAll(Integer page, Integer pageSize) {
        return PessoaFisicaEntity.findAll()
                .page(page, pageSize)
                .list();
    }
    public PessoaFisicaEntity findById(Long id){
        return (PessoaFisicaEntity) PessoaFisicaEntity.findByIdOptional(id)
                .orElseThrow(PessoaFisicaNotFindException::new);
    }
    public PessoaFisicaEntity updatePessoaFisica(Long id, PessoaFisicaEntity pessoaFisicaEntity) {
        var pessoa = findById(id);
        pessoa.name = pessoaFisicaEntity.name;
        pessoa.cpf = pessoaFisicaEntity.cpf;
        pessoa.email = pessoaFisicaEntity.email;
        pessoa.endereco = pessoaFisicaEntity.endereco;

        PessoaFisicaEntity.persist(pessoa);
        return pessoa;
    }
    public void deletePessoaFisica(Long id){
        var pessoa = findById(id);
        PessoaFisicaEntity.deleteById(pessoa.id);
    }

}
