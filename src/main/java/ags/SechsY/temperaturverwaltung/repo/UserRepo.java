package ags.SechsY.temperaturverwaltung.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE user.nickname = :nickname", nativeQuery = true)
    User findByNickname(@Param("nickname") String nickname);
}