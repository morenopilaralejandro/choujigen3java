package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Gender;
import com.choujigen.ogre.exception.GenreNotFoundException;
import com.choujigen.ogre.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public List<Gender> all() {
		return genreRepository.findAll();
	}

	@Override
	public Gender one(Long id) {
		return genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
	}

	@Override
	public Gender insert(Gender newObj) {
		return genreRepository.save(newObj);
	}

	@Override
	public Gender replace(Gender newObj, Long id) {
		return genreRepository.findById(id).map(oldObj -> {
			oldObj.setGenreNameJa(newObj.getGenreNameJa());
			oldObj.setGenreNameEn(newObj.getGenreNameEn());
			oldObj.setGenreNameEs(newObj.getGenreNameEs());
			oldObj.setGenreSymbol(newObj.getGenreSymbol());
			return genreRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGenreId(id);
			return genreRepository.save(newObj);
		});
	}

	@Override
	public void delete(Long id) {
		genreRepository.deleteById(id);
	}
}
