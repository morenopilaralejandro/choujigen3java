package com.choujigen.ogre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
