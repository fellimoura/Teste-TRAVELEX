package br.com.confidencecambio.javabasico.repository;

import br.com.confidencecambio.javabasico.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<ClienteEntity, Long> {
    ClienteEntity findByNome(String nome);
}
