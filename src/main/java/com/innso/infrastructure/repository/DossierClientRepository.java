package com.innso.infrastructure.repository;

import com.innso.domain.suivi.model.DossierClient;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierClientRepository extends JpaRepository<DossierClient, UUID> {

}
