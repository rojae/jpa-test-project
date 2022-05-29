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


    // N+1 문제가 동일하게 발생한다.
    // 아직까지는 지연로딩이 걸려있고, join을 했어도 프록시로 가져오는건 변함이 없기 때문이다.
    @Test
    @DisplayName("일반 jpql문, Join으로 N+1 문제는 풀리지 않는다.")
    void testJPQL() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAllJPQL();
        System.out.println("== end ==");
    }

    // fetch는 지연 로딩이 걸려있는 연관관계에 대해서 한번에 같이 즉시로딩해주는 구문
    @Test
    @DisplayName("Fetch join을 통해서 N+1 문제가 해결이 된다.")
    void testJPQLFetch() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAllJPQLFetch();
        System.out.println("== end ==");
    }


}
