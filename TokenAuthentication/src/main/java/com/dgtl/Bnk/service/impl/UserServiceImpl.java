package com.dgtl.Bnk.service.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgtl.Bnk.model.User;
import com.dgtl.Bnk.repository.UserRepository;
import com.dgtl.Bnk.service.UserService;

import javassist.tools.rmi.ObjectNotFoundException;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public User findByUsernameOrEmail(String usernameOrEmail) {
		try {
			User user = userRepository.findByUsernameOrEmail(usernameOrEmail);
			return user;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) throws ObjectNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("User not found");
		}
		return user.get();
	}

}
