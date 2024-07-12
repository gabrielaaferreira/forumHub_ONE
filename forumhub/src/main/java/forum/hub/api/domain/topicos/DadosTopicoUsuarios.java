package forum.hub.api.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopicoUsuarios(@NotNull @NotBlank String titulo, @NotNull @NotBlank String mensagem, @NotNull @NotBlank String autor, @NotNull Curso curso) {

	public String getTitulo() {
		return this.titulo;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public String getAutor() {
		return this.autor;
	}

	public Curso getCurso() {
		return this.curso;
	}

}
