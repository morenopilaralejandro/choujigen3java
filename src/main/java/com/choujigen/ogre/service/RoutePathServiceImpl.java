package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.RoutePath;
import com.choujigen.ogre.exception.RoutePathNotFoundException;
import com.choujigen.ogre.repository.RoutePathRepository;

@Service
public class RoutePathServiceImpl implements RoutePathService {
	@Autowired
	private RoutePathRepository routePathRepository;

	@Override
	public List<RoutePath> all() {
		return routePathRepository.findAll();
	}

	@Override
	public RoutePath one(Long id) {
		return routePathRepository.findById(id).orElseThrow(() -> new RoutePathNotFoundException(id));
	}

	@Override
	public RoutePath insert(RoutePath newObj) {
		return routePathRepository.save(newObj);
	}

	@Override
	public RoutePath replace(RoutePath newObj, Long id) {
		return routePathRepository.findById(id).map(oldObj -> {
			oldObj.setRoutePathOrder(newObj.getRoutePathOrder());
			oldObj.setExtraBattleRoute(newObj.getExtraBattleRoute());
			oldObj.setRewardN(newObj.getRewardN());
			oldObj.setRewardS(newObj.getRewardS());
			return routePathRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setRoutePathId(id);
			return routePathRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		routePathRepository.deleteById(id);
	}
}
