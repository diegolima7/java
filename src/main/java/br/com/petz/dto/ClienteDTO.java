package br.com.petz.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.petz.enums.SexoCliente;
import io.swagger.annotations.ApiModelProperty;

public class ClienteDTO {

	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private SexoCliente sexo;
	private String endereco;

	public ClienteDTO() {
	}

	public ClienteDTO(String cpf, String nome, String email, String telefone, SexoCliente sexo, String endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	@NotEmpty(message = "CPF Obrigatório")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotEmpty(message = "Nome Obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Email Obrigatório")
	@Email(message="Favor informar um email válido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "Telefone Obrigatório")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public SexoCliente getSexo() {
		return sexo;
	}

	public void setSexo(SexoCliente sexo) {
		this.sexo = sexo;
	}

	@NotEmpty(message = "Endereço Obrigatório")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
