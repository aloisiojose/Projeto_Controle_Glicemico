
package com.projetos.controleglicemico.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MedicamentoPaciente")
public class MedicamentoPaciente implements Serializable {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome Comercial", length = 100, nullable = false)
    private String nomeComercial;
    
    @Column(name = "nome Quimico", length = 100, nullable = false)
    private String nomeQuimico;
    
    @Column(name = "Prescriação médica", length = 100, nullable = false)
    private String prescreicaoMedica;
    
    @Column(name = "Descrição", length = 100, nullable = false)
    private String descricao;
    
    @Column(name = "dataColeta", length = 10, nullable = false)
    private LocalDate dataHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getNomeQuimico() {
        return nomeQuimico;
    }

    public void setNomeQuimico(String nomeQuimico) {
        this.nomeQuimico = nomeQuimico;
    }

    public String getPrescreicaoMedica() {
        return prescreicaoMedica;
    }

    public void setPrescreicaoMedica(String prescreicaoMedica) {
        this.prescreicaoMedica = prescreicaoMedica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

   
}
