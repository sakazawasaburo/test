package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByCustid(String custid);

    public User findByUsername(String username);

    public User findByOrgname(String orgname);

    public User findByPassword(String password);

}