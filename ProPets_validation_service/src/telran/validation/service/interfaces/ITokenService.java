package telran.validation.service.interfaces;

import java.util.HashSet;

import telran.validation.domain.entities.AccountEntity;
import telran.validation.domain.entities.AccountingRoles;

public interface ITokenService {
	
	String createToken(AccountEntity accountEntity);
	String createToken(String email, String pass, HashSet<AccountingRoles> roles);
	String validateToken(String token);
	String[] decompileToken(String token);
	String[] validateAuth(String token);

}
