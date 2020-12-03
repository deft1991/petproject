package repository;

import entity.QUser;
import entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ExCustomRepository<User, QUser, Long> {
}
