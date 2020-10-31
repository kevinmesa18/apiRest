package co.nuvu.api.apirest.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import co.nuvu.api.apirest.model.User;
import co.nuvu.api.apirest.service.UserService;
import co.nuvu.api.apirest.utils.Sha1;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = new User();
		try {
			String pwd;
			pwd = Sha1.sha1(password);
			user = userService.validateUser(email, pwd);		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (user == null) {
			return "Unregistered user or incorrect credentials";
		} else {
			String token = getJWTToken(email);
			return token;			
		}
	}
	
	private String getJWTToken(String email) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(email)
				.claim("authorities",grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,secretKey.getBytes()).compact();
		return "Bearer " + token;
	}
	
	
	
	@GetMapping("api/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("api/users/{id}")
	public Optional<User> getUser(@PathVariable("id") Integer id) {
		return userService.getUser(id);
	}
	
	@PostMapping("api/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("api/users")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("api/users/{id}")
	public void deleteCard(@PathVariable("id") Integer id){
		userService.deleteUser(id);
	}

}
