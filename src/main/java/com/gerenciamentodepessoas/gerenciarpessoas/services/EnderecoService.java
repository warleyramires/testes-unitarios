package com.gerenciamentodepessoas.gerenciarpessoas.services;

import com.gerenciamentodepessoas.gerenciarpessoas.dtos.EnderecoRequestDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.dtos.EnderecoResponseDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Endereco;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Pessoa;
import com.gerenciamentodepessoas.gerenciarpessoas.repositories.EnderecoRepository;
import com.gerenciamentodepessoas.gerenciarpessoas.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public EnderecoResponseDTO createEndereco(Long pessoaId, EnderecoRequestDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.logradouro());
        endereco.setCep(dto.cep());
        endereco.setNumero(dto.numero());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setPessoa(pessoa);

        Endereco salvo = enderecoRepository.save(endereco);

        return new EnderecoResponseDTO(
                salvo.getId(),
                salvo.getLogradouro(),
                salvo.getCep(),
                salvo.getNumero(),
                salvo.getBairro(),
                salvo.getCidade()
        );

    }
}
