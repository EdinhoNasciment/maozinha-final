package com.maozinha.api.resource;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maozinha.api.domain.Donations;
import com.maozinha.api.domain.Maozinha;
import com.maozinha.api.repository.DonationsRepository;
import com.maozinha.api.repository.MaozinhaRepository;
import com.maozinha.api.service.DonationsService;
import com.maozinha.api.service.MaozinhaService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/donation")
public class DonationsResource {

	@Autowired
	private DonationsRepository donationsRepository;
	
	Donations donations;

	@Autowired
	private DonationsService donationsService;
	
	@PreAuthorize("hasAuthority('ROLE_SEARCH_MAOZINHA') and hasAuthority('SCOPE_read')")
	public List<Donations> listDonations() {

		return donationsRepository.findAll();

	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_MAOZINHA') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Donations> findById(@PathVariable Long id) {

		Optional<Donations> donation = donationsRepository.findById(id);

		if (donation.isPresent()) {

			return ResponseEntity.ok(donation.get());

		}

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_MAOZINHA') and hasAuthority('SCOPE_write')")
	public Donations create(@Valid @RequestBody Donations donation, HttpServletResponse response) {

		boolean isComplete;
		Maozinha maozinha;

		return donationsRepository.save(donation);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_MAOZINHA') and hasAuthority('SCOPE_write')")
	public void remove(@PathVariable Long id) {
		donationsRepository.deleteById(id);
	}
	
}
