package com.ty.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.User;
import com.ty.SpringBoot_FoodApp.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User updateUser(User user, int id) {
		Optional<User> user2 = repo.findById(id);
		if (user2.isPresent()) {
			user.setId(id);
			repo.save(user);
			return user2.get();
		} else {
			return null;
		}

	}

	public User deleteUser(int id) {
		Optional<User> user2 = repo.findById(id);

		if (user2.isPresent()) {
			repo.deleteById(id);
			return user2.get();
		} else {
			return null;
		}
	}

	public User getUserById(int id) {
		Optional<User> user = repo.findById(id);

		if (user.isPresent()) {
         	return user.get();
		} else {
			return null;
		}

	}
}
