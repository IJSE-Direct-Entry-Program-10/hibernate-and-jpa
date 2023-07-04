package lk.ijse.dep10.rel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "actor_movie")
public class ActorMovie {
    @EmbeddedId
    private ActorMoviePK actorMoviePK;
    @Column(name = "joined_date", nullable = false)
    private Date joinedDate;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Actor actor;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movie movie;

    public ActorMovie(ActorMoviePK actorMoviePK, Date joinedDate) {
        this.actorMoviePK = actorMoviePK;
        this.joinedDate = joinedDate;
    }

    public ActorMovie(String actorId, String movieId, Date joinedDate) {
        this.actorMoviePK = new ActorMoviePK(actorId, movieId);
        this.joinedDate = joinedDate;
    }
}
