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
@Table(name="TAGS")
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column( name = "NAME", length = 25, unique = true )
    private @Getter @Setter String name;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tag tag)) return false;
        return Objects.equals(getId(), tag.getId());
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
                name = "SYS006_POSTS_TAGS",
                joinColumns = @JoinColumn(name = "TAG_ID"),
                inverseJoinColumns = @JoinColumn(name = "POST_ID"))
    private Set<Post> posts;

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
