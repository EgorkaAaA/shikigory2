package ru.egorkaaaa.demo.Controllers.Anime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import ru.egorkaaaa.demo.Entities.anime;

import java.util.Collection;

public interface animeControllerInterface {
    ResponseEntity<anime> createNewAnimeRequest(anime anime);

    ResponseEntity<Collection<anime>> getAllAnimeRequest();

    ResponseEntity<Collection<anime>> getAllAnimeSortedByAnimeNameRequest();

    ResponseEntity<anime> getAnimeByAnimeNameRequest(String animeName);

    ResponseEntity<anime> deleteAnimeByAnimeNameRequest(String animeName);

    ResponseEntity<anime> updateAnimeByAnimeNameRequest(String animeName);

    ResponseEntity<Collection<anime>> getAllAnimeSortedByRatingRequest();

    ResponseEntity<Collection<anime>> getTopAnimeByRatingRequest(int top);

    ResponseEntity<Collection<anime>> getAllAnimeSortedByViewsRequest();

    ResponseEntity<Collection<anime>> getTopAnimeByViewsRequest(int top);

}
