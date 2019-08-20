package com.Treinamentos.pontointreligente.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.Treinamentos.pontointreligente.api.enums.PerfilEnum;

@Entity
@Table(name = "tbl_funcionario")
public class Funcionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome", nullable = false,length = 60)
	private String nome;
	@Column(name = "email", nullable = false, length = 60)
	private String email;
	@Column(name = "senha",nullable = false,length = 10)
	private String senha;
	@Column(name = "cpf",nullable = false,length = 14)
	private String cpf;
	//JPA irá ignorar toda anotação com @Transient
	@Transient
	private BigDecimal valorHora;
	@Transient
	private Float qtdHorasTrabalhoDia;
	@Transient
	private Float qtdHorasAlmoco;
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil",nullable = false)
	private PerfilEnum perfil;
	@Column(name = "data_criacao",nullable = false)
	private Date dataCriacao;
	@Column(name ="data_atualizacao",nullable = false)
	private Date dataAtualizacao;
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}

	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@PreUpdate
	public void preUpdate(){
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist(){
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + 
				", email=" + email + 
				", senha=" + senha + 
				", cpf=" + cpf + 
				", valorHora=" + valorHora + 
				", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + 
				", qtdHorasAlmoco=" + qtdHorasAlmoco + 
				", perfil=" + perfil + 
				", dataCriacao=" + dataCriacao + 
				", dataAtualizacao=" + dataAtualizacao + 
				", empresa=" + empresa + 
				"]";
	}
	
	
	
}
