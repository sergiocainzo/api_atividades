package br.com.projeto.api_atividades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api_atividades.model.Atividade;
import br.com.projeto.api_atividades.model.RespostaAtividade;
import br.com.projeto.api_atividades.repository.AtividadeRepository;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository ar;

    @Autowired
    private RespostaAtividade ra;

    // Listagem das atividades
    public Iterable<Atividade> listarAtividadesOrdenadas() {
        Sort sort = Sort.by(Sort.Order.desc("prioridade"), Sort.Order.asc("nome"));
        return ar.findAll(sort);
    }

    // Cadastro e Alterar Atividades
    public ResponseEntity<?> cadastrarAlterar(Atividade at, String acao) {

        if (at.getNome().equals("")) {
            ra.setMensagem("O nome da atividade é obrigatória!");
            return new ResponseEntity<RespostaAtividade>(ra, HttpStatus.BAD_REQUEST);
        } else if (at.getDescricao().equals("")) {
            ra.setMensagem("A descrição da atividade é obrigatória!");
            return new ResponseEntity<RespostaAtividade>(ra, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<>(ar.save(at), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(ar.save(at), HttpStatus.OK);    
            }
        }
    }


    // Metodo para Remover Atividades
    public ResponseEntity<RespostaAtividade> remover(Long codigo){
        ar.deleteById(codigo);
        ra.setMensagem("A atividade foi removido com sucesso!");
        return new ResponseEntity<RespostaAtividade>(ra, HttpStatus.OK);
    }


}
