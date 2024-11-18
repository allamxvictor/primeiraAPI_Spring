package aprendendoSpring.primeiro_projeto_spring.service;

import aprendendoSpring.primeiro_projeto_spring.domain.model.User;

public interface UserService {
	User findById(Long id);
	
	User create(User userToCreate);
}
 	