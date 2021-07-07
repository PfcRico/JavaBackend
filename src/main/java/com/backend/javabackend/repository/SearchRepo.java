package com.backend.javabackend.repository;

import com.backend.javabackend.entity.Fanfic;
import org.apache.lucene.search.Query;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class SearchRepo {

    @Autowired
    private EntityManager entityManager;


    @Autowired
    public SearchRepo(EntityManagerFactory entityManagerFactory) {
        super();
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void initializeHibernateSearch() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Fanfic> searchInTextWord(String text) {

        Query keywordQuery = getQueryBuilder()
                .keyword()
                .onField("text")
                .matching(text)
                .createQuery();

        List<Fanfic> results = getJpaQuery(keywordQuery).getResultList();

        return results;
    }

    private javax.persistence.Query getJpaQuery(org.apache.lucene.search.Query luceneQuery) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        return fullTextEntityManager.createFullTextQuery(luceneQuery, Fanfic.class);
    }

    private QueryBuilder getQueryBuilder() {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Fanfic.class)
                .get();
    }
}
