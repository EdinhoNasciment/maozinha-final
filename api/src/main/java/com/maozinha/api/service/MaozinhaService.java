package com.maozinha.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maozinha.api.domain.Maozinha;
import com.maozinha.api.repository.MaozinhaRepository;

@Service
public class MaozinhaService {

	@Autowired
	private MaozinhaRepository maozinhaRepository;

	
	
	public Maozinha update(Long id, Maozinha maozinha) {
		Maozinha maozinhaSaved = maozinhaRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(maozinha, maozinhaSaved, "id");
		try {
			return maozinhaRepository.save(maozinhaSaved);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}