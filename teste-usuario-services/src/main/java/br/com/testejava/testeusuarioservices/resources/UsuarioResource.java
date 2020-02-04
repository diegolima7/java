package br.com.testejava.testeusuarioservices.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testejava.testeusuarioservices.beans.ProdutosBean;
import br.com.testejava.testeusuarioservices.beans.UsuarioBean;
import br.com.testejava.testeusuarioservices.beans.UsuarioProdutoBean;
import br.com.testejava.testeusuarioservices.responses.Response;
import br.com.testejava.testeusuarioservices.services.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping("/buscar/{id}")
	public ResponseEntity<UsuarioBean> buscaUsuarioPorId(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(this.service.buscaUsuarioPorId(id));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Response<UsuarioBean>> cadastrarUsuario(@Valid @RequestBody UsuarioBean usuario, BindingResult result) {
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<UsuarioBean>(erros));
		}
		return ResponseEntity.ok(new Response<UsuarioBean>(this.service.cadastrarUsuario(usuario)));
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<UsuarioBean> atualizarUsuario(@PathVariable(name = "id") String id, @RequestBody UsuarioBean usuario) {
		usuario.setId(id);
		return ResponseEntity.ok(this.service.atualizarUsuario(usuario));
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Integer> removerUsuario(@PathVariable(name = "id") String id) {
		this.service.removerUsuario(id);
		return ResponseEntity.ok(1);
	}
		
	@PostMapping("/associar/{id}")
	public ResponseEntity<UsuarioProdutoBean> associarUsuarioProduto(@PathVariable(name = "id") String id, @RequestBody ProdutosBean produto) {
		return ResponseEntity.ok(this.service.associarUsuarioProduto(id, produto));
	}

	
	@GetMapping("/{nome}")
	public ResponseEntity<List<UsuarioProdutoBean>> buscaProdutosPorUsuario(@PathVariable(name = "nome") String nome){
		return ResponseEntity.ok(this.service.buscaProdutosPorUsuario(nome));
	}

	
}