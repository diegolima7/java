package br.com.testejava.testeusuarioservices.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "produtos")
public class ProdutosBean {

	@Id
	@ApiModelProperty(hidden = true)
	private String id;
	private String nome;

	public ProdutosBean() {
	}

	public ProdutosBean(String nome) {
		super();
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
