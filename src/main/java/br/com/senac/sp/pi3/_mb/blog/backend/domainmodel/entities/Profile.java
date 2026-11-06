package br.com.senac.sp.pi3._mb.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "PROFILES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "id")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(name = "BIO", nullable = true, length = 255)
    private @Getter @Setter String bio;

    @Column(name = "pictureUri", nullable = true, length = 255)
    private @Getter @Setter String pictureUri;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private @Getter @Setter User user;


}


