package com.gerenciamentodepessoas.gerenciarpessoas.services;

import com.gerenciamentodepessoas.gerenciarpessoas.dtos.EnderecoRequestDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.dtos.EnderecoResponseDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Endereco;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Pessoa;
import com.gerenciamentodepessoas.gerenciarpessoas.repositories.EnderecoRepository;
import com.gerenciamentodepessoas.gerenciarpessoas.repositories.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    public EnderecoServiceTest () {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void deveCriarEndereceo(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Maria");

        EnderecoRequestDTO enderecoRequestDTO = new EnderecoRequestDTO(
                "Rua A",
                "39450-090",
                "120",
                "Centro",
                "São Paulo"
        );

        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setLogradouro("Rua A");
        endereco.setCep("39450-090");
        endereco.setNumero("120");
        endereco.setBairro("Centro");
        endereco.setPessoa(pessoa);

        when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(endereco);

        EnderecoResponseDTO enderecoResponseDTO = enderecoService.createEndereco(pessoa.getId(), enderecoRequestDTO);
        assertNotNull(enderecoResponseDTO);
        assertEquals(endereco.getId(), enderecoResponseDTO.id());
        assertEquals(endereco.getLogradouro(), enderecoResponseDTO.logradouro());
        assertEquals(endereco.getCep(), enderecoResponseDTO.cep());
        assertEquals(endereco.getNumero(), enderecoResponseDTO.numero());
        assertEquals(endereco.getBairro(), enderecoResponseDTO.bairro());
        assertEquals(endereco.getCidade(), enderecoResponseDTO.cidade());

        verify(pessoaRepository, times(1)).findById(pessoa.getId());
        verify(enderecoRepository, times(1)).save(any(Endereco.class));

    }

    @Test
    void deveBuscarTodosEnderecosDeUmaPessoa(){
        Pessoa p1 = new Pessoa();
        p1.setId(1L);
        p1.setNome("Luizinho");

        Endereco endereco1 = new Endereco();
        endereco1.setId(1L);
        endereco1.setLogradouro("Rua A");
        endereco1.setCep("39450-090");
        endereco1.setNumero("120");
        endereco1.setBairro("Centro");
        endereco1.setCidade("Campinas");
        endereco1.setPessoa(p1);
        Endereco endereco2 = new Endereco();
        endereco2.setId(2L);
        endereco2.setLogradouro("Rua B");
        endereco2.setCep("39450-130");
        endereco2.setNumero("98");
        endereco2.setBairro("Buritis");
        endereco2.setCidade("Belo Horizonte");
        endereco2.setPessoa(p1);

        List<Endereco> enderecos = List.of(endereco1, endereco2);

        when(pessoaRepository.findById(p1.getId())).thenReturn(Optional.of(p1));
        when(enderecoRepository.findByPessoa(p1)).thenReturn(enderecos);

        List<EnderecoResponseDTO> responseDTOList = enderecoService.listEnderecosByPessoaId(p1.getId());
        assertNotNull(responseDTOList);
        assertEquals(2, responseDTOList.size());

        verify(pessoaRepository, times(1)).findById(p1.getId());
        verify(enderecoRepository, times(1)).findByPessoa(p1);
    }



}