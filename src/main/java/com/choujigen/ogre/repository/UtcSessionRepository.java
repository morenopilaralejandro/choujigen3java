package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.UtcSession;

public interface UtcSessionRepository extends JpaRepository<UtcSession, Long> {

}
