package mx.com.axity.persistence;

import mx.com.axity.model.UserDO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<UserDO, Integer> {
    UserDO findById(int id);
}
