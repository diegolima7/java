package br.com.testejava.testeusuarioservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testejava.testeusuarioservices.beans.ProdutosBean;
import br.com.testejava.testeusuarioservices.beans.UsuarioBean;
import br.com.testejava.testeusuarioservices.beans.UsuarioProdutoBean;
import br.com.testejava.testeusuarioservices.repositories.UsuarioProdutoRepository;
import br.com.testejava.testeusuarioservices.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioProdutoRepository usuarioProdutoRepository;


	public UsuarioBean buscaUsuarioPorId(String id) {

		return this.usuarioRepository.findById(id).get();
	}

	public UsuarioBean cadastrarUsuario(UsuarioBean usuario) {

		return this.usuarioRepository.save(usuario);
	}

	public UsuarioBean atualizarUsuario(UsuarioBean usuario) {

		return this.usuarioRepository.save(usuario);
	}

	public void removerUsuario(String id) {

		this.usuarioRepository.deleteById(id);

	}

	public UsuarioProdutoBean associarUsuarioProduto(String id, ProdutosBean produto) {

		 UsuarioBean user = this.usuarioRepository.findById(id).get();
				
		UsuarioProdutoBean usuarioProdutoAtual = new UsuarioProdutoBean();

		List<UsuarioProdutoBean> lista = (ArrayList<UsuarioProdutoBean>) usuarioProdutoRepository.findAll();

		if(!lista.isEmpty()) {
			for (UsuarioProdutoBean usuarioProduto : lista) {

				if (usuarioProduto.getNomeUsuario().equals(user.getNome())&& 
					usuarioProduto.getNomeProduto().equals(produto.getNome()) &&
					usuarioProduto.getStatus().equals("Ativo")
					) {
					usuarioProduto.setStatus("Cancelado");
					usuarioProdutoRepository.save(usuarioProduto);
					usuarioProdutoAtual.setNomeProduto(produto.getNome());
					usuarioProdutoAtual.setNomeUsuario(user.getNome());
					usuarioProdutoAtual.setStatus("Ativo");
					usuarioProdutoRepository.save(usuarioProdutoAtual);
					return usuarioProdutoAtual;
				}
			}
		}

		usuarioProdutoAtual.setNomeProduto(produto.getNome());
		usuarioProdutoAtual.setNomeUsuario(user.getNome());
		usuarioProdutoAtual.setStatus("Ativo");
		usuarioProdutoRepository.save(usuarioProdutoAtual);

		return usuarioProdutoAtual;
	}

	public List<UsuarioProdutoBean> buscaProdutosPorUsuario(String nome) {
				
		return usuarioProdutoRepository.findByNomeUsuario(nome);
	}

}
