package ru.egorkaaaa.demo.Entities.Lists;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.egorkaaaa.demo.Entities.Keys.animeRatingKey;
import ru.egorkaaaa.demo.Entities.anime;
import ru.egorkaaaa.demo.Entities.user;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class animeList {
    @EmbeddedId
    private animeRatingKey id;

    @ManyToOne
    @MapsId("animeName")
    @JoinColumn(name="anime_name")
    @NotNull
    private anime animeName;

    @ManyToOne
    @MapsId("userName")
    @JoinColumn(name="user_name")
    @NotNull
    private user userName;

    @Null
    @Min(value = 0,message = "Rating must be between of 3 at 10")
    @Max(value = 10,message = "Rating must be between of 3 at 10")
    private byte rating;
}
