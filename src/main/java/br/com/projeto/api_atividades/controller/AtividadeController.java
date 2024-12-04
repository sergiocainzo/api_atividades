package br.com.projeto.api_atividades.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api_atividades.model.Atividade;
import br.com.projeto.api_atividades.model.RespostaAtividade;
import br.com.projeto.api_atividades.service.AtividadeService;

@RestController
@RequestMapping // Mapeamento correto para a URL
public class AtividadeController {

    // Construtor
    @Autowired
    private AtividadeService as;

    // Confirmação da Rota Ativa da API
    @GetMapping("/")
    public String rota() {
        return "API de produtos funcionando!!";
    }

    // Listar as atividades
    @GetMapping("/listar")
    public Iterable<Atividade> listarAtividadesOrdenadas() {
        return as.listarAtividadesOrdenadas();
    }

    // Criar as atividades
    @PostMapping("/cadastrar")
    public ResponseEntity<?> salvarAtividade(@RequestBody Atividade atividade) {
        return as.cadastrarAlterar(atividade, "cadastrar");
    }

    // Alterar os dados das atividades
    @PutMapping("/alterar")
    public ResponseEntity<?> alterarAtividade(@RequestBody Atividade atividade) {
        return as.cadastrarAlterar(atividade, "alterar");
    }

    // Excluir atividade
    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaAtividade> excluir(@PathVariable long codigo) {
        return as.remover(codigo);
    }

}
