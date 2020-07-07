package br.com.petz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petz.beans.ClienteBean;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteBean, Integer> {

	public ClienteBean findByCpf(String cpf);

}
