package com.codegym.dao.repository.location;

import com.codegym.dao.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommuneRepository extends JpaRepository<Commune, String> {
    public List<Commune> findAllByMaqhContaining(String id);
}
