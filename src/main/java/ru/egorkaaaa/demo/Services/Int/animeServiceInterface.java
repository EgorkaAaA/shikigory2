package ru.egorkaaaa.demo.Services.Int;

import ru.egorkaaaa.demo.Entities.anime;
import ru.egorkaaaa.demo.Exceptions.*;

import java.util.Collection;

public interface animeServiceInterface {
    void createNewAnime(anime anime) throws animeAllReadyExistsException;

    Collection<anime> getAllAnime();

    void deleteAnimeByAnimeName(String animeName) throws animeNotFoundException;

    void updateAnimeBuAnimeName(String lastAnimeName, anime updatedAnime) throws animeNotFoundException;

    anime findAnimeByAnimeName(String animeName) throws animeNotFoundException;
}
