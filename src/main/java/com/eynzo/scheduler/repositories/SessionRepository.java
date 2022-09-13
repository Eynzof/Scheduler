package com.eynzo.scheduler.repositories;

import com.eynzo.scheduler.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {


}
