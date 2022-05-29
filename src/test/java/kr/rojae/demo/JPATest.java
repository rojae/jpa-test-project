package kr.rojae.demo;

import kr.rojae.demo.user.User;
import kr.rojae.demo.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class JPATest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @DisplayName("Lazy type은 User 검색 후 필드 검색을 할 때 N+1문제가 발생한다.")
    void userFindTest() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAll();
        for(User user : users)
            System.out.println(user.getArticles().size());
        System.out.println("== end ==");
    }

}
