package br.com.petz.enums;

public enum SexoCliente {

	Masculino("M"), Feminino("F");

	private String descricao;

	SexoCliente(String sexo) {
		this.descricao = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

}
