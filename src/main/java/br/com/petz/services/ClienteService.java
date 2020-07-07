package br.com.petz.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.beans.ClienteBean;
import br.com.petz.dto.ClienteDTO;
import br.com.petz.repositories.ClienteRepository;
import javassist.NotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private ModelMapper model = new ModelMapper();

	public ClienteBean cadastrarCliente(ClienteDTO dto) {
		ClienteBean cliente = model.map(dto, ClienteBean.class);
		return this.clienteRepository.save(cliente);
	}

	public ClienteBean atualizarCliente(int idCliente, ClienteDTO dto) throws NotFoundException {
		this.buscaClientePorId(idCliente);
		ClienteBean cliente = model.map(dto, ClienteBean.class);
		cliente.setIdCliente(idCliente);
		return this.clienteRepository.save(cliente);
	}

	public void removerCliente(Integer id) {
		this.clienteRepository.deleteById(id);
	}

	public ClienteBean buscaClientePorId(Integer id) throws NotFoundException {
		return this.clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
	}

}
