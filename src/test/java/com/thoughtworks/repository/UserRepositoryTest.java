package com.thoughtworks.repository;

import com.thoughtworks.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_save_user_successfully() {
        User user = User.builder().id("1").name("1").build();
        User user1 = userRepository.save(user);

        assertEquals(user1.getId(), "1");
        assertEquals(user1.getName(), "1");
    }

    @Test
    public void should_get_user_successfully() {
        User user = User.builder().id("1").name("1").build();
        entityManager.persist(user);
        List<User> userList = userRepository.findAll();


        assertEquals(userList.size(), 1);
        assertEquals(userList.get(0).getId(), "1");
        assertEquals(userList.get(0).getName(), "1");
    }
}
