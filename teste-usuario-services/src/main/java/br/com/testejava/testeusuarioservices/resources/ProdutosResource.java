package br.com.testejava.testeusuarioservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testejava.testeusuarioservices.beans.ProdutosBean;
import br.com.testejava.testeusuarioservices.beans.UsuarioProdutoBean;
import br.com.testejava.testeusuarioservices.services.ProdutosService;

@RestController
@RequestMapping("/products")
public class ProdutosResource {

	@Autowired
	private ProdutosService service;

	@GetMapping
	public ResponseEntity<List<ProdutosBean>> buscaProdutos() {
		return ResponseEntity.ok(this.service.buscaProdutos());
	}
	
	@GetMapping(value = {"/buscarUsuarioPorProduto", "/buscarUsuarioPorProduto/{nome}"})
	public ResponseEntity<List<UsuarioProdutoBean>> buscaUsuarioPorProduto(@PathVariable(name = "nome", required = false) String nome){
		
		if (nome != null) {
			return ResponseEntity.ok(this.service.buscaUsuarioPorProduto(nome));
	    } else {
	    	return ResponseEntity.ok(this.service.buscaUsuarioProdutoTodosAtivos());
	    }
	}

}