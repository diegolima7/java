package br.com.testejava.testeusuarioservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.testejava.testeusuarioservices.beans.ProdutosBean;

@Repository
public interface ProdutosRepository extends MongoRepository<ProdutosBean, String>{

}
