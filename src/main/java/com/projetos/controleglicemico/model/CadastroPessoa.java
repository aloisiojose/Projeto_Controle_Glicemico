
package com.projetos.controleglicemico.model;

import com.projetos.controleglicemico.util.TipoSanguinio;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Cadastro_Pessoa")
public class CadastroPessoa implements Serializable {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "cpf", length = 100, nullable = false)
    private String cpf;
    
    @Column(name = "endereco", length = 100, nullable = true)
    private String endereco;
    
    @Column(name = "bairro", length = 100, nullable = true)
    private String bairro;
    
    @Column(name = "numero", length = 8, nullable = true)
    private Long numero;
    
    @Column(name = "uf", length = 2, nullable = true)
    private String uf;
    
    @Column(name = "cep", length = 10, nullable = true)
    private Long cep;
    
      @Column(name = "data_nascimento", nullable = true)
    private LocalDate nascimento;
    
    @Column(name = "masculino", length =10, nullable = true)
    private String masculino;
    
    @Column(name = "femino", length =10, nullable = true)
    private String feminino;
    
    @Column(name = "celularResponsavel", length =10, nullable = true)
    private Long celularResponsavel;
    
    @Column(name = "complemento", length = 8, nullable = true)
    private String complemento;
    
    @Column(name = "telefone", length = 100, nullable = true)
    private Long telefone;
    
    @Column(name = "celular", length = 11, nullable = true)
    private Long celular;
        
    @Column(name = "responsavel", length = 100, nullable = true)
    private String responsavel;
    
    @Column(name = "telefone_Responsvel", length = 100, nullable = true)
    private Long telefoneResponsvel;
    
    @Column(name = "tipoSanguinio", length = 100, nullable = true)
    private String TipoSanguinio;
    
    @OneToOne
    private CidadeEstado CidadeEstado;
    
    @Column(name="ativo")
    private boolean ativo;
    
    @Column(name="sexo", length=1)
    private String sexo;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

   
    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getTelefoneResponsvel() {
        return telefoneResponsvel;
    }

    public void setTelefoneResponsvel(Long telefoneResponsvel) {
        this.telefoneResponsvel = telefoneResponsvel;
    }

    public CidadeEstado getCidadeEstado() {
        return CidadeEstado;
    }

    public void setCidadeEstado(CidadeEstado CidadeEstado) {
        this.CidadeEstado = CidadeEstado;
    }

    public String getTipoSanguinio() {
        return TipoSanguinio;
    }

    public void setTipoSanguinio(String TipoSanguinio) {
        this.TipoSanguinio = TipoSanguinio;
    }

    
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getMasculino() {
        return masculino;
    }

    public void setMasculino(String masculino) {
        this.masculino = masculino;
    }

    public String getFeminino() {
        return feminino;
    }

    public void setFeminino(String feminino) {
        this.feminino = feminino;
    }

    public Long getCelularResponsavel() {
        return celularResponsavel;
    }

    public void setCelularResponsavel(Long celularResponsavel) {
        this.celularResponsavel = celularResponsavel;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
