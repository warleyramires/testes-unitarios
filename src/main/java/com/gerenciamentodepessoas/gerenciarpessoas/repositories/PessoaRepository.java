package com.gerenciamentodepessoas.gerenciarpessoas.repositories;

import com.gerenciamentodepessoas.gerenciarpessoas.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
