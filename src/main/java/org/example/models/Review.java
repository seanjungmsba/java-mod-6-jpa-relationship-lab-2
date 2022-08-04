package org.example.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REVIEWS_DATA")
public class Review {

    @Id
    @GeneratedValue
    private int id;

    private int score;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "SUBMITTED_BY")
    private Game game;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", game=" + game +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
