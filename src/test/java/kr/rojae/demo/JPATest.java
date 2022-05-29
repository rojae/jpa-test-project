package kr.rojae.demo;

import kr.rojae.demo.user.User;
import kr.rojae.demo.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPATest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Eager type은 User를 전체 검색할 때 N+1문제가 발생한다.")
    void userFindTest() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAll();
        System.out.println("== end ==");
    }

}
