package forum.hub.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import forum.hub.api.domain.topicos.DadosAtualizacaoTopico;
import forum.hub.api.domain.topicos.DadosDetalhamentoTopico;
import forum.hub.api.domain.topicos.DadosListagemTopico;
import forum.hub.api.domain.topicos.DadosTopicoUsuarios;
import forum.hub.api.domain.topicos.Topico;
import forum.hub.api.domain.topicos.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity postar(@RequestBody @Valid DadosTopicoUsuarios dados, UriComponentsBuilder uriBuilder) {
	    if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Tópico com o mesmo título e mensagem já existe.");
	    }

	    var topico = new Topico(dados);
	    repository.save(topico);

	    var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
	    return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
	}

	
	@GetMapping
	public ResponseEntity <Page<DadosListagemTopico>> listar(@PageableDefault(size = 10) Pageable paginacao){
		var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosListagemTopico> listarTopicoId(@PathVariable Long id) {
	    var topico = repository.getReferenceById(id);
	    return ResponseEntity.ok(new DadosListagemTopico(topico));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizartopico(@RequestBody @Valid DadosAtualizacaoTopico dados) {
		var topico = repository.getReferenceById(dados.id());
		topico.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluirtopico(@PathVariable Long id) {
		var topico = repository.getReferenceById(id);
		topico.excluir();
		repository.save(topico);
		
		return ResponseEntity.noContent().build();
	}

}
