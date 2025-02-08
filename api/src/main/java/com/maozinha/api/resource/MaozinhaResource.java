package com.maozinha.api.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maozinha.api.domain.Maozinha;
import com.maozinha.api.repository.MaozinhaRepository;
import com.maozinha.api.service.MaozinhaService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/maozinhas")
public class MaozinhaResource {

	@Autowired
	private MaozinhaRepository maozinhaRepository;

	@Autowired
	private MaozinhaService maozinhaService;

	final String UPLOAD_DIR = "C:\\Users\\erubensdona2\\Downloads\\api\\api\\images\\uploads";

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_MAOZINHA') and hasAuthority('SCOPE_read')")
	public List<Maozinha> listMaozinhas() {

		return maozinhaRepository.findAll();

	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_MAOZINHA') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Maozinha> findById(@PathVariable Long id) {

		Optional<Maozinha> maozinha = maozinhaRepository.findById(id);

		if (maozinha.isPresent()) {

			return ResponseEntity.ok(maozinha.get());

		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_MAOZINHA') and hasAuthority('SCOPE_write')")
	public Maozinha create(@Valid @RequestBody Maozinha maozinha, /*@RequestParam MultipartFile image,*/ HttpServletResponse response) {

		//Path uploadPath = Paths.get(UPLOAD_DIR);
		
		/*try {
			if(!image.isEmpty()) {
				byte[] bytes = image.getBytes();
				Path finalPath = Paths.get(uploadPath+generateUniqueFileName(image.getOriginalFilename()));
				Files.write(finalPath, bytes);
				maozinha.setImgUrl(String.valueOf(finalPath));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		

		return maozinhaRepository.save(maozinha);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_MAOZINHA') and hasAuthority('SCOPE_write')")
	public void remove(@PathVariable Long id) {
		maozinhaRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_MAOZINHA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Maozinha> update(@PathVariable Long id, @Valid @RequestBody Maozinha maozinha) {
		Maozinha maozinhaSaved = maozinhaService.update(id, maozinha);
		return ResponseEntity.ok(maozinhaSaved);
	}
	
	public String generateUniqueFileName(String originalFilename) {
	    String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	    String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
	    return timestamp + "_" + originalFilename.replace(" ", "_");
	}

}