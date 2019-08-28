package com.cts.activitystream.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.activitystream.domain.User;
import com.cts.activitystream.repositories.UserAuthenticationRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
/*@ContextConfiguration(classes={MovieCruiserAuthenticationServiceApplication.class})*/
public class UserRepositoryTest {

	@MockBean
	private UserAuthenticationRepository userRepository;

	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User("John", "John jenny", "Bob", "123456", new Date());
	}

	@Test
	public void testRegisterUSerSuccess() {
		userRepository.save(user);
		Optional<User> object = userRepository.findById(user.getUsername());
		assertThat(object.equals(user));

	}

}
