package com.gerenciamentodepessoas.gerenciarpessoas.dtos;

import java.time.LocalDate;

public record PessoaResponseDTO(
        Long id,
        String nome,
        LocalDate dataNascimento
) {
}
