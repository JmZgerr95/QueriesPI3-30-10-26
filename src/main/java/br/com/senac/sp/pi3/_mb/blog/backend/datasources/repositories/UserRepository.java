package br.com.senac.sp.pi3._mb.blog.backend.datasources.repositories;

import br.com.senac.sp.pi3._mb.blog.backend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public List<User> findByName( String name );


    //JPQL: Java Persistence Query Language
    @Query("SELECT DISTINCT u from User u JOIN u.roles r WHERE r.name = :roleName")
    public List<User> findByRole(String roleName);

    @Query(value = "SELECT DISTINCT(u.id) FROM SYSTEM_USERS u, ROLES r WHERE r.id = u.ID AND r.NAME = :roleName", nativeQuery = true)
    public List<User> findByRoles(String roleName);
}
