package kr.rojae.demo.user;

import kr.rojae.demo.article.Article;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity(name = "USER")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Article> articles = Collections.emptySet();
}
