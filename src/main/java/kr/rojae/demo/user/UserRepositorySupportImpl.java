package kr.rojae.demo.user;

import static kr.rojae.demo.user.QUser.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositorySupportImpl implements UserRepositorySupport{

    @Autowired
    JPAQueryFactory query;

    @Override
    public User findById(long id) {
        return query.selectFrom(user).where(user.id.eq(id)).fetchOne();
    }

}
