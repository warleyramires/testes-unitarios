package com.gerenciamentodepessoas.gerenciarpessoas.services;

import com.gerenciamentodepessoas.gerenciarpessoas.dtos.PessoaRequestDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.dtos.PessoaResponseDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Pessoa;
import com.gerenciamentodepessoas.gerenciarpessoas.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaResponseDTO criarPessoa(PessoaRequestDTO pessoaRequestDTO){

        try{
            var entity = new Pessoa();
            entity.setNome(pessoaRequestDTO.nome());
            entity.setDataNascimento(pessoaRequestDTO.dataNascimento());

            pessoaRepository.save(entity);
            var response = new PessoaResponseDTO(entity.getId(),entity.getNome(),entity.getDataNascimento());
            return response;
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel criar pessoa: " + e.getMessage());
        }
    }

    public List<PessoaResponseDTO> listarPessoas(){
        try{
            List<Pessoa> pessoas = pessoaRepository.findAll();

            return pessoas.stream()
                    .map(pessoa -> new PessoaResponseDTO(
                            pessoa.getId(),
                            pessoa.getNome(),
                            pessoa.getDataNascimento()
                    )).toList();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
