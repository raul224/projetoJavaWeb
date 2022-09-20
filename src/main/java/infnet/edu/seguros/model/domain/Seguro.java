package infnet.edu.seguros.model.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Seguros")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Seguro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroContrato;
	private LocalDateTime dataAssinatura;
	private LocalDateTime dataFim;
	private float valorContrato;
	private float valorIndenizacao;
	private boolean ativo;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "seguros")
	private List<Orcamento> orcamentos;
	
	public Seguro() {
		// TODO Auto-generated constructor stub
	}
	
	public Seguro(LocalDateTime dataAssinatura, LocalDateTime dataFim, float valorContrato, float valorIndenizacao) {
		this.dataAssinatura = dataAssinatura;
		this.dataFim = dataFim;
		this.valorContrato = valorContrato;
		this.valorIndenizacao = valorIndenizacao;
		this.ativo = true;
	}

	public Integer getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public LocalDateTime getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(LocalDateTime dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public float getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(float valorContrato) {
		this.valorContrato = valorContrato;
	}

	public float getValorIndenizacao() {
		return valorIndenizacao;
	}

	public void setValorIndenizacao(float valorIndenizacao) {
		this.valorIndenizacao = valorIndenizacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}
}
