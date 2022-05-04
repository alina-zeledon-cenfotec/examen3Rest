package com.cenfotec.examen3Rest.examen3Rest.repositories;

import com.cenfotec.examen3Rest.examen3Rest.domain.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long> { }
