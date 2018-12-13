/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author angelodezoti
 */
@Entity
@Table(name = "aluguel_has_veiculo")
@NamedQueries({
    @NamedQuery(name = "AluguelHasVeiculo.findAll", query = "SELECT a FROM AluguelHasVeiculo a")})
public class AluguelHasVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_aluguel_has_veiculo")
    private Integer idAluguelHasVeiculo;
    @Basic(optional = false)
    @Column(name = "quantidade_dias")
    private int quantidadeDias;
    @Basic(optional = false)
    @Column(name = "valor_dia")
    private String valorDia;
    @Basic(optional = false)
    @Column(name = "data")
    private String data;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_fim")
    private String horaFim;
    @JoinColumn(name = "aluguel_id_aluguel", referencedColumnName = "id_aluguel")
    @ManyToOne(optional = false)
    private Aluguel aluguelIdAluguel;
    @JoinColumn(name = "veiculo_id_veiculo", referencedColumnName = "id_veiculo")
    @ManyToOne(optional = false)
    private Veiculo veiculoIdVeiculo;

    public AluguelHasVeiculo() {
    }

    public AluguelHasVeiculo(Integer idAluguelHasVeiculo) {
        this.idAluguelHasVeiculo = idAluguelHasVeiculo;
    }

    public AluguelHasVeiculo(Integer idAluguelHasVeiculo, int quantidadeDias, String valorDia, String data) {
        this.idAluguelHasVeiculo = idAluguelHasVeiculo;
        this.quantidadeDias = quantidadeDias;
        this.valorDia = valorDia;
        this.data = data;
    }

    public Integer getIdAluguelHasVeiculo() {
        return idAluguelHasVeiculo;
    }

    public void setIdAluguelHasVeiculo(Integer idAluguelHasVeiculo) {
        this.idAluguelHasVeiculo = idAluguelHasVeiculo;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public String getValorDia() {
        return valorDia;
    }

    public void setValorDia(String valorDia) {
        this.valorDia = valorDia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public Aluguel getAluguelIdAluguel() {
        return aluguelIdAluguel;
    }

    public void setAluguelIdAluguel(Aluguel aluguelIdAluguel) {
        this.aluguelIdAluguel = aluguelIdAluguel;
    }

    public Veiculo getVeiculoIdVeiculo() {
        return veiculoIdVeiculo;
    }

    public void setVeiculoIdVeiculo(Veiculo veiculoIdVeiculo) {
        this.veiculoIdVeiculo = veiculoIdVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluguelHasVeiculo != null ? idAluguelHasVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AluguelHasVeiculo)) {
            return false;
        }
        AluguelHasVeiculo other = (AluguelHasVeiculo) object;
        if ((this.idAluguelHasVeiculo == null && other.idAluguelHasVeiculo != null) || (this.idAluguelHasVeiculo != null && !this.idAluguelHasVeiculo.equals(other.idAluguelHasVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AluguelHasVeiculo[ idAluguelHasVeiculo=" + idAluguelHasVeiculo + " ]";
    }
    
}
