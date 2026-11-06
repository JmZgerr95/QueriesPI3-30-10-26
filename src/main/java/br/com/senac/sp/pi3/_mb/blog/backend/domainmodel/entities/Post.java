package br.com.senac.sp.pi3._mb.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="POSTS")
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @GeneratedValue(strategy= GenerationType.UUID)
    private @Getter @Setter @Id UUID id;

    @Column(name="TITLE", length = 40)
    private @Getter @Setter String title;

    @Column(name="CONTENT", length = 255)
    private @Getter @Setter String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private @Getter @Setter User user;

    @ManyToMany(mappedBy = "posts")
    private @Getter @Setter Set<Tag> tags;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Post post)) return false;
        return Objects.equals(getId(), post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
