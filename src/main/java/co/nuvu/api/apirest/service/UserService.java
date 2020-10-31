package co.nuvu.api.apirest.service;

import java.util.List;
import java.util.Optional;

import co.nuvu.api.apirest.model.User;
import co.nuvu.api.apirest.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUser(Integer id) {
		return userRepository.findById(id);
	}
	
	public User updateUser(User user) {
		Optional<User> userval =  userRepository.findById(user.getId());
		if(userval != null) {
			return userRepository.save(user);			
		} else {
			return null;
		}
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	public User validateUser(String email, String password) {
		return userRepository.validateUser(email, password);
	}
}
