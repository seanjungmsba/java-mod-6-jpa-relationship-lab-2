package org.example;

import org.example.models.Game;
import org.example.models.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        // create and use transactions
        transaction.begin();

        // create game instances
        Game game1 = new Game();
        game1.setTitle("Maple Story");
        game1.setGenre("RPG");
        game1.setPlatform("Nexon");
        game1.setPrice(50);
        game1.setCreated_at(Date.from(Instant.now()));
        game1.setUpdated_at(Date.from(Instant.now()));

        Game game2 = new Game();
        game2.setTitle("Sudden Attack");
        game2.setGenre("FPS");
        game2.setPlatform("Netmarble");
        game2.setPrice(35);
        game2.setCreated_at(Date.from(Instant.now()));
        game2.setUpdated_at(Date.from(Instant.now()));

        // create reviews
        Review review1 = new Review();
        review1.setScore(85);
        review1.setComment("Love the cute character");
        review1.setCreated_at(Date.from(Instant.now()));
        review1.setUpdated_at(Date.from(Instant.now()));

        Review review2 = new Review();
        review2.setScore(70);
        review2.setComment("It is a decent RPG game, but the places are limited");
        review2.setCreated_at(Date.from(Instant.now()));
        review2.setUpdated_at(Date.from(Instant.now()));

        Review review3 = new Review();
        review3.setScore(95);
        review3.setComment("Love this FPS game!");
        review3.setCreated_at(Date.from(Instant.now()));
        review3.setUpdated_at(Date.from(Instant.now()));

        Review review4 = new Review();
        review4.setScore(90);
        review4.setComment("I like how there are so many weapons that user can choose from!");
        review4.setCreated_at(Date.from(Instant.now()));
        review4.setUpdated_at(Date.from(Instant.now()));

        // create game -< reviews associations
        game1.addReview(review1);
        game1.addReview(review2);
        game2.addReview(review3);
        game2.addReview(review4);

        review1.setGame(game1);
        review2.setGame(game1);
        review3.setGame(game2);
        review4.setGame(game2);

        // persist
        entityManager.persist(game1);
        entityManager.persist(game2);
        entityManager.persist(review1);
        entityManager.persist(review2);
        entityManager.persist(review3);
        entityManager.persist(review4);

        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}