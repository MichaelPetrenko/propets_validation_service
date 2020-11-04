package telran.validation.controllers;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.validation.api.RequestDto;
import telran.validation.api.TokenValidationApiConstants;
import telran.validation.dao.AccountsRepository;
import telran.validation.domain.entities.AccountEntity;
import telran.validation.domain.entities.AccountingRoles;
import telran.validation.service.interfaces.ITokenService;

@RestController
public class ValidationController {

	@Autowired
	ITokenService tokenService;
	
	@Autowired
	AccountsRepository repo;
	
	@PostMapping(value = TokenValidationApiConstants.CREATE_BY_ENTITY)
	String createTokenByEntity(@RequestBody AccountEntity accountEntity) {
		return tokenService.createToken(accountEntity);
	}
	
	@PostMapping(value = TokenValidationApiConstants.CREATE_BY_EMAIL)
	String createTokenByEmail(@RequestBody RequestDto dto) {
		String email = dto.email;
		String pass = dto.pass;
		HashSet<AccountingRoles> roles = dto.roles;
		return tokenService.createToken(email, pass, roles);
	}
	
	@PostMapping(value = TokenValidationApiConstants.DECOMPILE_TOKEN)
	String[] decompileToken(@RequestBody String token) {
		return tokenService.decompileToken(token);
	}
	
	@PostMapping(value = TokenValidationApiConstants.VALIDATE_TOKEN)
	String validate(@RequestBody String token) {
		return tokenService.validateToken(token);
	}
	
	@PostMapping(value = TokenValidationApiConstants.VALIDATE_AUTH)
	String[] validateAuth(@RequestBody String token) {
		return tokenService.validateAuth(token);
	}
	
}
