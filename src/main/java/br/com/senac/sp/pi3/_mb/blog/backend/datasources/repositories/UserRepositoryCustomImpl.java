package br.com.senac.sp.pi3._mb.blog.backend.datasources.repositories;

import br.com.senac.sp.pi3._mb.blog.backend.domainmodel.entities.QUser;
import br.com.senac.sp.pi3._mb.blog.backend.domainmodel.entities.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryCustomImpl {

    @PersistenceContext
    private EntityManager entityManager;

    private final QUser user = QUser.user;

    public Optional<User> findByEmailCriteria(String email){
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);

        List<Predicate> predicates = new LinkedList<>();
        predicates.add(builder.equal(userRoot.get("email"),email));
        criteria.select(userRoot).where(predicates);

        return Optional.ofNullable(
                this.entityManager.createQuery(criteria)
                        .getSingleResult()
        );
    }

    //A mesma coisa de cima, só que sem usar String
    public Optional<User> findByEmailCriteriaDSL(String email){
        return Optional.ofNullable(
                new JPAQueryFactory(this.entityManager)
                        .selectFrom(user)
                        .where(user.email.eq(email))
                        .fetchOne()
        );
    }

    public List<User> findUserByRole(String roleName){
        return new JPAQueryFactory(this.entityManager)
                .selectFrom(user)
                .where(user.roles.any().name.eq(roleName))
                .fetch();
    }
}
