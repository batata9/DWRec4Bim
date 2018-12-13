/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author angelodezoti
 */
@Entity
@Table(name = "aluguel")
@NamedQueries({
    @NamedQuery(name = "Aluguel.findAll", query = "SELECT a FROM Aluguel a")})
public class Aluguel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_aluguel")
    private Integer idAluguel;
    @Column(name = "data_aluguel")
    private String dataAluguel;
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluguelIdAluguel")
    private List<AluguelHasVeiculo> aluguelHasVeiculoList;

    public Aluguel() {
    }

    public Aluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Integer getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public String getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public List<AluguelHasVeiculo> getAluguelHasVeiculoList() {
        return aluguelHasVeiculoList;
    }

    public void setAluguelHasVeiculoList(List<AluguelHasVeiculo> aluguelHasVeiculoList) {
        this.aluguelHasVeiculoList = aluguelHasVeiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluguel != null ? idAluguel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        if ((this.idAluguel == null && other.idAluguel != null) || (this.idAluguel != null && !this.idAluguel.equals(other.idAluguel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idAluguel + "";
    }
    
}
