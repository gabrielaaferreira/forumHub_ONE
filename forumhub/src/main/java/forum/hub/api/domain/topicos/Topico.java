package forum.hub.api.domain.topicos;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDate data_criacao;
    
    private String autor;
    
    @Enumerated(EnumType.STRING)
    private Curso curso;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    private Boolean ativo;
    
    public Topico() {
    }
    
    
    public Topico(DadosTopicoUsuarios dados) {
    	this.setAutor(dados.autor());
    	this.setTitulo(dados.titulo());
    	this.setMensagem(dados.mensagem());
    	this.curso = dados.curso();
    	this.status = Status.ABERTO;
    	this.setData_criacao(LocalDate.now());
    	this.setAtivo(true);
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDate getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
		if(dados.status() != null) {
			this.status = dados.status();
		}
		
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void excluir() {
		this.ativo = false;
	}

	public boolean isAtivo() {
		return ativo;
	}
}
