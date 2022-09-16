package com.dailycodebuffer.spring.data.jpa.config;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.product.Product;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.user.User;
import com.dailycodebuffer.spring.data.jpa.tutorial.repository.ProductRepository;
import com.dailycodebuffer.spring.data.jpa.tutorial.repository.UserRepository;

@SpringBootTest
@EnableTransactionManagement
class MultipleDBConfigurationTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("userTransactionManager")
    public void whenCreatingUser_thenCreated() {
    	 User user = new User();
         user.setName("John");
         user.setEmail("john@test.com");
         user.setAge(20);
         user = userRepository.save(user);

         assertNotNull(userRepository.findById(user.getId()));
    }
    
    @Test
    @Transactional("userTransactionManager")
    public void whenCreatingUsersWithSameEmail_thenRollback() {
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("john@test.com");
        user1.setAge(20);
        user1 = userRepository.save(user1);
        assertNotNull(userRepository.findById(user1.getId()));

        User user2 = new User();
        user2.setName("Tom");
        user2.setEmail("john@test.com");
        user2.setAge(10);
        try {
            user2 = userRepository.save(user2);
        } catch (DataIntegrityViolationException e) {
        }

        assertNull(userRepository.findById(user2.getId()));
    }

    @Test
    @Transactional("productTransactionManager")
    public void whenCreatingProduct_thenCreated() {
        Product product = new Product();
        product.setName("Book");
        product.setId(2);
        product.setPrice(20);
        product = productRepository.save(product);

        assertNotNull(productRepository.findById(product.getId()));
    }

    
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
