package br.unipe.fujioka.java.web.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@SequenceGenerator(sequenceName="conta_seq", name="conta_id")
public class Conta {
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="conta_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;
	@Temporal(TemporalType.DATE)
	private Date dataFechamento;
	private Double creditoBloqueado;
	private Double debitoBloqueado;

	
	@ManyToMany
	private List<Cliente> clientes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Double getCreditoBloqueado() {
		return creditoBloqueado;
	}
	public void setCreditoBloqueado(Double creditoBloqueado) {
		this.creditoBloqueado = creditoBloqueado;
	}
	public Double getDebitoBloqueado() {
		return debitoBloqueado;
	}
	public void setDebitoBloqueado(Double debitoBloqueado) {
		this.debitoBloqueado = debitoBloqueado;
	}
	

}
