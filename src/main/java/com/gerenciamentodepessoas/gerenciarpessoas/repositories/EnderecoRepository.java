package com.gerenciamentodepessoas.gerenciarpessoas.repositories;

import com.gerenciamentodepessoas.gerenciarpessoas.entities.Endereco;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByPessoa(Pessoa pessoa);
}
