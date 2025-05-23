package com.gerenciamentodepessoas.gerenciarpessoas.controller;

import com.gerenciamentodepessoas.gerenciarpessoas.dtos.EnderecoRequestDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.dtos.EnderecoResponseDTO;
import com.gerenciamentodepessoas.gerenciarpessoas.entities.Endereco;
import com.gerenciamentodepessoas.gerenciarpessoas.services.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<EnderecoResponseDTO> criarEndereco(@PathVariable Long pessoaId,
                                                             @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        try{
            EnderecoResponseDTO enderecoResponseDTO = enderecoService.createEndereco(pessoaId, enderecoRequestDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(enderecoResponseDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> listarEnderecos(){
        try{
            List<EnderecoResponseDTO> listEndereco = enderecoService.listAllEnderecos();

            return ResponseEntity.status(HttpStatus.OK).body(listEndereco);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<EnderecoResponseDTO>> listrEnderecosByPessoa(@PathVariable Long pessoaId){
       try{
           List<EnderecoResponseDTO> listEndereco = enderecoService.listEnderecosByPessoaId(pessoaId);
           return ResponseEntity.status(HttpStatus.OK).body(listEndereco);
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }
}
