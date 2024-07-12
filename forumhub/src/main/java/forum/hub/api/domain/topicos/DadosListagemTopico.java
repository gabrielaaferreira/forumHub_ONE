package forum.hub.api.domain.topicos;

import java.time.LocalDate;

public record DadosListagemTopico(Long id, String titulo, Curso curso, String autor, Status status, LocalDate data_criacao, String mensagem) {
	
	public DadosListagemTopico(Topico topico) {
		this(topico.getId(), topico.getTitulo(), topico.getCurso(), topico.getAutor(), topico.getStatus(), topico.getData_criacao(), topico.getMensagem());
	}

}
