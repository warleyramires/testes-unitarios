package com.gerenciamentodepessoas.gerenciarpessoas.dtos;

public record EnderecoRequestDTO(
         String logradouro,
         String cep,
         String numero,
         String bairro,
         String cidade
) {
}
