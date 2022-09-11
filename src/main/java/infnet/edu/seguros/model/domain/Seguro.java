package infnet.edu.seguros.model.domain;

import java.time.LocalDateTime;

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

    public LocalDateTime getDataAssinatura() {
        return dataAssinatura;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public float getValorContrato() {
        return valorContrato;
    }

    public float getValorIndenizacao() {
        return valorIndenizacao;
    }
    
    public Usuario getUsuario() {
		return usuario;
	}

    public boolean isAtivo() {
        return ativo;
    }
    
    
    
    public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public void setDataAssinatura(LocalDateTime dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public void setValorContrato(float valorContrato) {
		this.valorContrato = valorContrato;
	}

	public void setValorIndenizacao(float valorIndenizacao) {
		this.valorIndenizacao = valorIndenizacao;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
