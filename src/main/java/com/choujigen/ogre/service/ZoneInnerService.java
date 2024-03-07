package com.choujigen.ogre.service;

import java.util.List;

import com.choujigen.ogre.domain.ZoneInner;

public interface ZoneInnerService {
	List<ZoneInner> all();

	ZoneInner one(Long id);

	ZoneInner insert(ZoneInner newObj);

	ZoneInner replace(ZoneInner newObj, Long id);

	void delete(Long id);
}
