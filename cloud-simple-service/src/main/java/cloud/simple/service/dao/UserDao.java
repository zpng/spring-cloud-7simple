package cloud.simple.service.dao;

import cloud.simple.service.model.User;

import java.util.List;


public interface UserDao {

	List<User> findAll();
}
