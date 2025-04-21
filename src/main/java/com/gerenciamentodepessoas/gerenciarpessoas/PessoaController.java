package com.gerenciamentodepessoas.gerenciarpessoas;

import com.gerenciamentodepessoas.gerenciarpessoas.dtos.PessoaRequestDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.dtos.PessoaResponseDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> createPessoa(@RequestBody PessoaRequestDTO pessoaRequestDTO) {
        try{

            PessoaResponseDTO p1 = pessoaService.criarPessoa(pessoaRequestDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(p1);


            }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
