package com.dgtl.Bnk.service;
import com.dgtl.Bnk.model.User;

import javassist.tools.rmi.ObjectNotFoundException;

public interface UserService {
	
	 User findByUsernameOrEmail(String usermaneOrEmail);
	 User findById(Long id) throws ObjectNotFoundException;
}