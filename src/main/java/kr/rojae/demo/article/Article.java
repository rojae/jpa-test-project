package kr.rojae.demo.article;

import kr.rojae.demo.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ARTICLE")
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
