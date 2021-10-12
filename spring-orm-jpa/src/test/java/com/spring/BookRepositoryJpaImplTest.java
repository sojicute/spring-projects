package com.spring;

import com.spring.repositories.BookRepositoryJpa;
import com.spring.repositories.BookRepositoryJpaImpl;
import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BookRepositoryJpaImpl.class)
public class BookRepositoryJpaImplTest {

    @Autowired
    private BookRepositoryJpaImpl repositoryJpa;

    @Autowired
    private TestEntityManager em;

    @Test
    void shouldReturnCorrectBookListWithAllInfo() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory().unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);


        System.out.println("\n\n\n\n----------------------------------------------------------------------------------------------------------");
        val books = repositoryJpa.findAll();
        assertThat(books).isNotNull().hasSize(1)
                .allMatch(s -> !s.getAuthor().equals(""));
        System.out.println("----------------------------------------------------------------------------------------------------------\n\n\n\n");

        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(5);
    }
}
