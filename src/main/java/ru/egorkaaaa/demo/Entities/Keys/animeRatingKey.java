package ru.egorkaaaa.demo.Entities.Keys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
public class animeRatingKey implements Serializable {

    @Column(name="anime_name")
    @NotNull
    private String animeName;

    @Column(name="user_name")
    @NotNull
    private String userName;
}
