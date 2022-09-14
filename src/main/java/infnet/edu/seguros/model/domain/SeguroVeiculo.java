package infnet.edu.seguros.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Veicular")
public class SeguroVeiculo extends Seguro{
    private String placa;
    private String crlv;
    private String tipoVeiculo;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCrlv() {
        return crlv;
    }

    public void setCrlv(String crlv) {
        this.crlv = crlv;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}