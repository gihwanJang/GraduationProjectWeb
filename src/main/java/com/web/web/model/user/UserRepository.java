package com.web.web.model.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
    @Transactional
    @Query(value = "select * from user where user.id = :id and user.pw = :pw", nativeQuery = true)
    User findMember(String id, String pw);
}
