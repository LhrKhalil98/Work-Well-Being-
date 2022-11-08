package com.esprit.pidev.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName  implements GrantedAuthority {
	ADMIN,
	EMPLOYEE;
	@Override
	public String getAuthority() {
	return "ROLE_" + name();
	}
	

}
