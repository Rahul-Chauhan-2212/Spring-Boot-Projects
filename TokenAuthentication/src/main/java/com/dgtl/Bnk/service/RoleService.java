package com.dgtl.Bnk.service;
import java.util.List;

import com.dgtl.Bnk.model.Role;

import javassist.tools.rmi.ObjectNotFoundException;

public interface RoleService {
	
	 List<Role> findAll()throws ObjectNotFoundException;
}