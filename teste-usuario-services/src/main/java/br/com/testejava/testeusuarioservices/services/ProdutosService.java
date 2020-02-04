package br.com.testejava.testeusuarioservices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testejava.testeusuarioservices.beans.ProdutosBean;
import br.com.testejava.testeusuarioservices.beans.UsuarioProdutoBean;
import br.com.testejava.testeusuarioservices.repositories.ProdutosRepository;
import br.com.testejava.testeusuarioservices.repositories.UsuarioProdutoRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private UsuarioProdutoRepository usuarioProdutoRepository;

	public List<ProdutosBean> buscaProdutos() {

		return this.produtosRepository.findAll();
	}

	public List<UsuarioProdutoBean> buscaUsuarioPorProduto(String nomeProduto) {

		List<UsuarioProdutoBean> lista = (ArrayList<UsuarioProdutoBean>) usuarioProdutoRepository.findByNomeProduto(nomeProduto);

		return lista;
	}
		
	public List<UsuarioProdutoBean> buscaUsuarioProdutoTodosAtivos() {

		List<UsuarioProdutoBean> lista = usuarioProdutoRepository.findAll();

		List<UsuarioProdutoBean> listaFinal = new ArrayList<UsuarioProdutoBean>();
		
		if (!lista.isEmpty()) {
			for (UsuarioProdutoBean usuarioProduto : lista) {

				if (!usuarioProduto.getStatus().equals("Cancelado")) {
					listaFinal.add(usuarioProduto);
				}
			}
			return listaFinal;
		}

		return null;
	}

}
