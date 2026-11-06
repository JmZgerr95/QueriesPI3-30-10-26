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
@Table(name="ROLES")
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private @Getter
    @Setter UUID id;

    @Column( name = "NAME", length = 25, unique = true )
    private @Getter @Setter String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private @Getter @Setter Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Role role)) return false;
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}