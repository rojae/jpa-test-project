package kr.rojae.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositorySupport {
    List<User> findAll();

    @Query("select distinct u from USER u left join u.articles")
    List<User> findAllJPQL();

    @Query("select distinct u from USER u left join fetch u.articles")
    List<User> findAllJPQLFetch();
}
