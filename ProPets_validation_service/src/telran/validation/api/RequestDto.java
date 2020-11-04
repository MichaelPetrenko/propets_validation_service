package telran.validation.api;

import java.util.HashSet;

import telran.validation.domain.entities.AccountingRoles;

public class RequestDto {
	public String email;
	public String pass;
	public HashSet<AccountingRoles> roles;
	public RequestDto() {
		super();
	}
	public RequestDto(String email, String pass, HashSet<AccountingRoles> roles) {
		super();
		this.email = email;
		this.pass = pass;
		this.roles = roles;
	}

}
