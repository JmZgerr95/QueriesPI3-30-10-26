package br.com.senac.sp.pi3._mb.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="SYSTEM_USERS")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private @Getter
    @Setter
    @Id UUID id;

    @Column(name = "NAME", length = 60)
    private @Getter
    @Setter String name;

    @Column(name = "EMAIL", length = 30)
    private @Getter
    @Setter String email;

    @Column(name = "PASSWORD", length = 15)
    private @Getter
    @Setter String password;

    @OneToOne(mappedBy = "user")
    private @Getter
    @Setter Profile profile;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "USERS_ROLES",

            joinColumns =
            @JoinColumn(name = "USER_ID"),

            inverseJoinColumns =
            @JoinColumn(name = "ROLE_ID")
    )
    private @Getter
    @Setter Set<Role> roles;


    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private @Getter
    @Setter Set<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
