package infnet.edu.seguros.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Veicular")
public class SeguroVeiculo extends Seguro{
    private String placa;
    private String crlv;
    private String TipoVeiculo; //Trocar para enumerador, tendo apenas carro e moto
}