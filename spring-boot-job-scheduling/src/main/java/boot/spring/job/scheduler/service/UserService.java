package boot.spring.job.scheduler.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import boot.spring.job.scheduler.entity.User;
import boot.spring.job.scheduler.repository.UserRepository;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Scheduled(fixedRate = 5000)
	public void saveUserData() {
		User user = new User();
		user.setName("User" + new Random().nextInt());
		userRepository.save(user);
		logger.debug(new Date().toString() + " User Created-->" + user.toString());

	}

	@Scheduled(cron = "0/15 * * * * *")
	public void fetchUserData() {
		List<User> allUsers = userRepository.findAll();
		logger.debug(new Date().toString() + " User Fetched-->" + allUsers);

	}

}
