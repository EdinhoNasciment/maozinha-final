package com.maozinha.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.maozinha.api.domain.User;
import com.maozinha.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/*public User update(Long id, User user) {
		User userSaved = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(user, userSaved, "id");
		try {
			return userRepository.save(userSaved);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	public User update(Long id, User user) {
		User userSaved = findUserById(id);
		BeanUtils.copyProperties(user, userSaved, "id");
		return userRepository.save(userSaved);
	}
	
	public void updateActiveProperty(Long id, Boolean active) {
		User userSaved = findUserById(id);
		userSaved.setActive(active);
		userRepository.save(userSaved);
	}
	
	public User findUserById(Long id) {
		User userSaved = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return userSaved;
	}

	
}
