package br.com.petz.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.beans.ClienteBean;
import br.com.petz.beans.PetBean;
import br.com.petz.dto.PetDTO;
import br.com.petz.repositories.PetRepository;
import javassist.NotFoundException;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;

	private ModelMapper model = new ModelMapper();

	public PetBean cadastrarPet(PetBean pet) {
		return this.petRepository.save(pet);
	}

	public PetBean atualizarPet(int id, PetDTO dto) throws NotFoundException {

		PetBean petCliente = this.buscaPetPorId(id);

		PetBean pet = model.map(dto, PetBean.class);
		pet.setCliente(petCliente.getCliente());
		pet.setIdPet(id);
		return this.petRepository.save(pet);
	}

	public void removerPet(Integer id) {
		this.petRepository.deleteById(id);
	}

	public PetBean buscaPetPorId(Integer id) throws NotFoundException {
		return this.petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet não encontrado"));
	}

}
