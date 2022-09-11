package infnet.edu.seguros.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "Domicilios")
public class SeguroDomicilio extends Seguro{
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    private String cpfProprietario;
    private int metragemImovel;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    public int getMetragemImovel() {
        return metragemImovel;
    }

    public void setMetragemImovel(int metragemImovel) {
        this.metragemImovel = metragemImovel;
    }
}
