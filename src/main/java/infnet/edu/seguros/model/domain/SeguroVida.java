package infnet.edu.seguros.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Vida")
public class SeguroVida extends Seguro{
    private String cpf;
    private int anoNascimento;
    private String cpfBeneficiario;
}
