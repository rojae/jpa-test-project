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

    // Eager Type으로 User를 검색함.
    // 1:N인 엔티티에 의해서, N+1 문제가 크게 발생한다.
    // 즉시로딩은 사용하지 말자.
    // 즉시로딩은 Jpql로 전달되는 과정에서 Jpql 후 Eager 감지로 인한
    // N 쿼리가 추가로 발생하는 경우가 있기 때문에 사용해서는 안된다.
    @Test
    @DisplayName("Eager type은 User를 전체 검색할 때 N+1문제가 발생한다.")
    void test() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAll();
        System.out.println("== end ==");
    }

}
