package telran.validation.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.validation.domain.entities.AccountEntity;

//@Repository
//Можно не писать аннотацию, потому-что аннотация есть в монго репозиторий
public interface AccountsRepository extends MongoRepository<AccountEntity, String>{

	
}
