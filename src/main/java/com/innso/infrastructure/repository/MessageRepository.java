package com.innso.infrastructure.repository;

import com.innso.domain.suivi.model.Message;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, UUID> {

}
