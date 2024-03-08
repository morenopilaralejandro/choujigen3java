package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Passwd;
import com.choujigen.ogre.exception.PasswdNotFoundException;
import com.choujigen.ogre.repository.PasswdRepository;

@Service
public class PasswdServiceImpl implements PasswdService {
	@Autowired
	private PasswdRepository passwdRepository;

	@Override
	public List<Passwd> all() {
		return passwdRepository.findAll();
	}

	@Override
	public Passwd one(Long id) {
		return passwdRepository.findById(id).orElseThrow(() -> new PasswdNotFoundException(id));
	}

	@Override
	public Passwd insert(Passwd newObj) {
		return passwdRepository.save(newObj);
	}

	@Override
	public Passwd replace(Passwd newObj, Long id) {
		return passwdRepository.findById(id).map(oldObj -> {
			oldObj.setPasswdJa(newObj.getPasswdJa());
			oldObj.setPasswdEn(newObj.getPasswdEn());
			oldObj.setPasswdEs(newObj.getPasswdEs());
			return passwdRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPasswdId(id);
			return passwdRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		passwdRepository.deleteById(id);
	}
}
