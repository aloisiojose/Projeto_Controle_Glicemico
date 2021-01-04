
package com.projetos.controleglicemico.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cidade_Estado_Cep")
public class CidadeEstado implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cidade", length = 8, nullable = false)
    private String cidade;
    @Column(name = "estado", length = 2, nullable = false)
    private String estado;
    @Column(name = "cep", length = 2, nullable = false)
    private Long cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "CidadeEstado{" + "cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + '}';
    }
    

}
