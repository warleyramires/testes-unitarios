package com.gerenciamentodepessoas.gerenciarpessoas.dtos;

import java.time.LocalDate;

public record PessoaRequestDTO(
        String nome,
        LocalDate dataNascimento
) {
}
