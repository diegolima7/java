package br.com.testejava.testeusuarioservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.testejava.testeusuarioservices.beans.UsuarioBean;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioBean, String> {

	public UsuarioBean findByCpf(String cpf);

}
