package ru.egorkaaaa.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="Anime")
@NoArgsConstructor
@AllArgsConstructor
public class anime {
    @Id
    @NotNull
    @JoinColumn(name = "anime_name")
    private String animeName;

    @NotNull
    @Min(value = 0, message = "Views must be 0 or more")
    private long views;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "studio_name")
    private studio studioName;

    @Min(value = 1, message = "Episodes must be between of 1 at 10000 ")
    @Max(value = 10000)
    @NotNull
    private short episodes;
}
