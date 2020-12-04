package br.com.confidencecambio.javabasico.repository;

import br.com.confidencecambio.javabasico.entity.RoboEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoboRepository extends JpaRepository<RoboEntity,Long> {
}
