package br.com.petz.controller;

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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.petz.beans.ClienteBean;
import br.com.petz.dto.ClienteDTO;
import br.com.petz.responses.Response;
import br.com.petz.services.ClienteService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping("/cadastrar")
	public ResponseEntity<Response<ClienteBean>> cadastrarCliente(@Valid @RequestBody ClienteDTO cliente,
			BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<ClienteBean>(erros));
		}
		return ResponseEntity.ok(new Response<ClienteBean>(this.service.cadastrarCliente(cliente)));
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<ClienteBean> atualizarcliente(@PathVariable(name = "id") Integer id,
			@RequestBody ClienteDTO cliente) throws NotFoundException {

		return ResponseEntity.ok(this.service.atualizarCliente(id, cliente));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<ClienteBean> buscaClientePorId(@PathVariable(name = "id") int id) {
		try {
			return ResponseEntity.ok(this.service.buscaClientePorId(id));
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> removerUsuario(@PathVariable(name = "id") int id) {
		this.service.removerCliente(id);
		return ResponseEntity.noContent().build();
	}

}