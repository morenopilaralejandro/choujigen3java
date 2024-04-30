package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.TournamentDropItem;
import com.choujigen.ogre.domain.TournamentDropItemId;

public interface TournamentDropItemRepository extends JpaRepository<TournamentDropItem, TournamentDropItemId> {

}
