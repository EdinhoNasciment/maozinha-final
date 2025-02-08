package com.maozinha.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maozinha.api.domain.Donations;
import com.maozinha.api.domain.Maozinha;
import com.maozinha.api.repository.DonationsRepository;
import com.maozinha.api.repository.MaozinhaRepository;
import com.maozinha.api.repository.UserRepository;

@Service
public class DonationsService {

	@Autowired
	private MaozinhaRepository maozinhaRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DonationsRepository donationsRepository;

	
	
	public Donations update(Long id, Donations donation) {
		Donations donationsSaved = donationsRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(donation, donationsSaved, "id");
		try {
			return donationsRepository.save(donationsSaved);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
