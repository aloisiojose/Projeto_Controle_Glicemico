package com.projetos.controleglicemico.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Coleta")
public class Coleta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", length = 100, nullable = true)
    private String nome;
    
    @Column(name = "cpf", length = 100, nullable = true)
    private String cpf;
    
    @Column(name = "horaColeta", length = 10, nullable = false)
    private LocalTime hora;
    
    @Column(name = "dataColeta", length = 10, nullable = true)
    private LocalDate data;
    
    @Column(name = "valorDiabete", length = 20, nullable = false)
    private Long valorDiabete;
    
    @Column(name = "valorPeso", length = 20, nullable = false)
    private Long valorPeso;
    
    @Column(name = "valroPressaoArterial", length = 20, nullable = false)
    private Long ValorPressaoArterial;
    
    @Column(name = "descrição", length = 255, nullable = false)
    private String descricao;
    
    @Column(name = "sexo", length = 20, nullable = false)
    private String sexo;
    
    @Column(name = "altura", length = 4, nullable = false)
    private String altura;
    
    @Column(name = "tipoSanguinio", length = 4, nullable = false)
    private String tipoSanguinio;
     
    @Column(name = "tipoAlimento", length = 4, nullable = false)
    private String tipoAlimento;
    
    @OneToOne
    private CadastroPessoa idCadastroPessoa;
    
    @OneToOne
    private CidadeEstado idCidadeEstado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getValorDiabete() {
        return valorDiabete;
    }

    public void setValorDiabete(Long valorDiabete) {
        this.valorDiabete = valorDiabete;
    }

    public Long getValorPeso() {
        return valorPeso;
    }

    public void setValorPeso(Long valorPeso) {
        this.valorPeso = valorPeso;
    }

    public Long getValorPressaoArterial() {
        return ValorPressaoArterial;
    }

    public void setValorPressaoArterial(Long ValorPressaoArterial) {
        this.ValorPressaoArterial = ValorPressaoArterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getTipoSanguinio() {
        return tipoSanguinio;
    }

    public void setTipoSanguinio(String tipoSanguinio) {
        this.tipoSanguinio = tipoSanguinio;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public CadastroPessoa getIdCadastroPessoa() {
        return idCadastroPessoa;
    }

    public void setIdCadastroPessoa(CadastroPessoa idCadastroPessoa) {
        this.idCadastroPessoa = idCadastroPessoa;
    }

    public CidadeEstado getIdCidadeEstado() {
        return idCidadeEstado;
    }

    public void setIdCidadeEstado(CidadeEstado idCidadeEstado) {
        this.idCidadeEstado = idCidadeEstado;
    }

    
    
}
