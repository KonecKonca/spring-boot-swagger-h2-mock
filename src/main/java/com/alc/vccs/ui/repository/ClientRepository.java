package com.alc.vccs.ui.repository;

import com.alc.vccs.ui.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> { }
