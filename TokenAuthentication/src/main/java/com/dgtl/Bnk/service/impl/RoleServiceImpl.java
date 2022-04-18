package com.dgtl.Bnk.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgtl.Bnk.model.Role;
import com.dgtl.Bnk.repository.RoleRepository;
import com.dgtl.Bnk.service.RoleService;

import javassist.tools.rmi.ObjectNotFoundException;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() throws ObjectNotFoundException {
		
			List<Role> roles = roleRepository.findAll();
			if(roles.isEmpty()){
				throw new ObjectNotFoundException("Role list is empty");
			}
			return roles;

	}

}
