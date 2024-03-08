package com.choujigen.ogre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Attri;
import com.choujigen.ogre.domain.Player;
import com.choujigen.ogre.domain.Positi;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	List<Player> findByAttri(Attri attri);

	List<Player> findByPositi(Positi positi);

	List<Player> findByAttriAndPositi(Attri attri, Positi positi);
}
