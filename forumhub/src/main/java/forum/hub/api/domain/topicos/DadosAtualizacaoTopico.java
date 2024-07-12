package forum.hub.api.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(@NotNull Long id, Status status) {
	
}
