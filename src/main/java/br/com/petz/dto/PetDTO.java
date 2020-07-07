package br.com.petz.dto;

import javax.validation.constraints.NotEmpty;

import br.com.petz.enums.SexoPet;
import br.com.petz.enums.TipoPet;
import io.swagger.annotations.ApiModelProperty;

public class PetDTO {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden=true)
	private ClienteDTO cliente;
	private String nome;
	private TipoPet tipoPet;
	private SexoPet sexoAnimal;

	public PetDTO() {
	}

	public PetDTO(String nome, TipoPet tipoPet, SexoPet sexo) {
		super();
		this.nome = nome;
		this.tipoPet = tipoPet;
		this.sexoAnimal = sexo;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	@NotEmpty(message = "Nome é Obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Tipo do Pet é Obrigatório")
	public TipoPet getTipoPet() {
		return tipoPet;
	}

	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
	}

	@NotEmpty(message = "Sexo do animal é Obrigatório")
	public SexoPet getSexoAnimal() {
		return sexoAnimal;
	}

	public void setSexoAnimal(SexoPet sexoAnimal) {
		this.sexoAnimal = sexoAnimal;
	}

}
