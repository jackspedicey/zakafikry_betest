package ms_zakafikry_betest.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ms_zakafikry_betest.demo.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByAccountNumber(String accountNumber);
    Optional<User> findByIdentityNumber(String identityNumber);
}
