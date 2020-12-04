package br.com.confidencecambio.javabasico.repository;

import br.com.confidencecambio.javabasico.entity.GerenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenteRepository extends JpaRepository<GerenteEntity,Long> {
}
