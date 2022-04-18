package boot.spring.job.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boot.spring.job.scheduler.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
