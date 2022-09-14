package infnet.edu.seguros.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Vida")
public class SeguroVida extends Seguro{
    private String cpf;
    private int anoNascimento;
    private String cpfBeneficiario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getCpfBeneficiario() {
        return cpfBeneficiario;
    }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }
}
