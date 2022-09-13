package com.eynzo.scheduler.repositories;

import com.eynzo.scheduler.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
