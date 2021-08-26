package ru.egorkaaaa.demo.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class studio {
    @Id
    @JoinColumn(name="studio_name")
    @NotNull
    @Size(min = 3, max = 40, message = "StudioName must be between of 3 at 40 characters")
    private String studioName;
}
