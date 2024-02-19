package com.choujigen.ogre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choujigen.ogre.domain.Genre;
import com.choujigen.ogre.exception.GenreNotFoundException;
import com.choujigen.ogre.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public List<Genre> all() {
		return genreRepository.findAll();
	}

	@Override
	public Genre one(Long id) {
		return genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
	}

	@Override
	public Genre insert(Genre newObj) {
		return genreRepository.save(newObj);
	}

	@Override
	public Genre replace(Genre newObj, Long id) {
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
