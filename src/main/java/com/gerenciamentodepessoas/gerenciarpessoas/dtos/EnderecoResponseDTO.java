package com.gerenciamentodepessoas.gerenciarpessoas.dtos;

public record EnderecoResponseDTO(
        Long id,
        String logradouro,
        String cep,
        String numero,
        String bairro,
        String cidade
) {
}
