package kr.rojae.demo;

import kr.rojae.demo.user.User;
import kr.rojae.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final UserRepository userRepository;

    @GetMapping("/")
    public String Home() {
        List<User> users = userRepository.findAll();
        for (User user : users)
            logger.info("id : " + user.getId() + " name : " + user.getName());
        return "home";
    }

    @GetMapping("/user/{userId}")
    public String findUserApi(@PathVariable long userId) {
        User selectedUser = userRepository.findById(userId);
        logger.info("id : " + selectedUser.getId() + " name : " + selectedUser.getName());
        return "home";
    }


}
