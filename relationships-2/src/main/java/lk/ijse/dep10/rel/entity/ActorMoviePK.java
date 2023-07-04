package lk.ijse.dep10.rel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActorMoviePK implements Serializable {
    @Column(name = "actor_id")
    private String actorId;
    @Column(name = "movie_id")
    private String movieId;
}
