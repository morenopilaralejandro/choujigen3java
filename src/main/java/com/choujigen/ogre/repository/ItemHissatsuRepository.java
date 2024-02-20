package com.choujigen.ogre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choujigen.ogre.domain.Attri;
import com.choujigen.ogre.domain.HissatsuType;
import com.choujigen.ogre.domain.ItemHissatsu;

public interface ItemHissatsuRepository extends JpaRepository<ItemHissatsu, Long> {
	List<ItemHissatsu> findByHissatsuTypeAndAttriIn(HissatsuType hissatsuType, List<Attri> attri);
}
