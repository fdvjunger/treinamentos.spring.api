package com.Treinamentos.pontointreligente.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "tbl_empresa")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "razao_social",nullable = false,length = 60)
	private String razaoSocial;
	@Column(name = "cnpj",nullable = false,length = 18)
	private String cnpj;
	@Column(name = "data_criacao",nullable = false)
	private Date dataCriacao;
	@Column(name = "date_atualizacao")
	private Date dataAtualizacao;
	@OneToMany(mappedBy = "empresa",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios;
	
	public Empresa() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}


	@Override
	public String toString() {
		return "Empresa [razaoSocial=" + razaoSocial + 
				", cnpj=" + cnpj + 
				", dataCriacao=" + dataCriacao+
				", dataAtualizacao=" + dataAtualizacao + 
				"]";
	}
	
	
	
	
	
	
}
