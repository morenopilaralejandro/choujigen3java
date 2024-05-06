package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.PracticeGameDropItem;
import com.choujigen.ogre.domain.PracticeGameDropItemId;

public interface PracticeGameDropItemRepository extends JpaRepository<PracticeGameDropItem, PracticeGameDropItemId> {

}
