package com.gerenciamentodepessoas.gerenciarpessoas.services;

import com.gerenciamentodepessoas.gerenciarpessoas.dtos.PessoaRequestDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.dtos.PessoaResponseDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Pessoa;
import com.gerenciamentodepessoas.gerenciarpessoas.repositories.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    public PessoaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarPessoa(){
        PessoaRequestDTO requestDTO = new PessoaRequestDTO("Maria", LocalDate.of(1990,5,20));

        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome(requestDTO.nome());
        pessoa.setDataNascimento(requestDTO.dataNascimento());

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        PessoaResponseDTO responseDTO = pessoaService.criarPessoa(requestDTO);

        assertNotNull(responseDTO);
        assertEquals("Maria", responseDTO.nome());
        assertEquals(LocalDate.of(1990,5,20), responseDTO.dataNascimento());
        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void deveListarTodasAsPessoas(){
        Pessoa p1 = new Pessoa();
        p1.setId(1L);
        p1.setNome("Maria");
        p1.setDataNascimento(LocalDate.of(1990,5,20));

        Pessoa p2 = new Pessoa();
        p2.setId(2L);
        p2.setNome("Valter");
        p2.setDataNascimento(LocalDate.of(1964,10,28));

        when(pessoaRepository.findAll()).thenReturn(List.of(p1,p2));

        List<PessoaResponseDTO> result = pessoaService.listarPessoas();

        assertEquals(2, result.size());
        assertEquals("Maria", result.get(0).nome());
        assertEquals("Valter", result.get(1).nome());

        verify(pessoaRepository, times(1)).findAll();

    }

}