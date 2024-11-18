package aprendendoSpring.primeiro_projeto_spring.service.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import aprendendoSpring.primeiro_projeto_spring.domain.model.User;
import aprendendoSpring.primeiro_projeto_spring.domain.repository.UserRepository;
import aprendendoSpring.primeiro_projeto_spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("This User ID alredy exists");
		}
		
		return userRepository.save(userToCreate);
	}

}
