package br.com.testejava.testeusuarioservices.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.testejava.testeusuarioservices.beans.UsuarioProdutoBean;

@Repository
public interface UsuarioProdutoRepository extends MongoRepository<UsuarioProdutoBean, String>{

	public List<UsuarioProdutoBean> findByNomeProduto(String nomeProduto);
	
	public List<UsuarioProdutoBean> findByNomeUsuario(String nomeUsuario);
	
}
