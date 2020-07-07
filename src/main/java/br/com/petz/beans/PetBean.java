package br.com.petz.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.petz.enums.SexoPet;
import br.com.petz.enums.TipoPet;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_pet")
public class PetBean {

	@Id
	@ApiModelProperty(hidden = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPet;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	@ApiModelProperty(hidden = true)
	private ClienteBean cliente;
		
	private String nome;
	private TipoPet tipoPet;
	private SexoPet sexoAnimal;

	public PetBean() {
	}

	public PetBean(String nome, TipoPet tipoPet, SexoPet sexo) {
		super();
		this.nome = nome;
		this.tipoPet = tipoPet;
		this.sexoAnimal = sexo;
	}

	public Integer getIdPet() {
		return idPet;
	}

	public void setIdPet(Integer idPet) {
		this.idPet = idPet;
	}

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPet getTipoPet() {
		return tipoPet;
	}

	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
	}

	public SexoPet getSexoAnimal() {
		return sexoAnimal;
	}

	public void setSexoAnimal(SexoPet sexoAnimal) {
		this.sexoAnimal = sexoAnimal;
	}

	public void setIdCliente(int id) {
		this.cliente = new ClienteBean();
		this.cliente.setIdCliente(id);
	}
}
