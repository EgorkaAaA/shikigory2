package ru.egorkaaaa.demo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egorkaaaa.demo.Entities.anime;
import ru.egorkaaaa.demo.Services.AnimeServiceImpl;
import ru.egorkaaaa.demo.Shikigori2Application;

import java.util.Collection;

@RestController
@RequestMapping("/animes")
public class animeController {
    private final AnimeServiceImpl animeService;
    private final Logger logger = LoggerFactory.getLogger(Shikigori2Application.class);

    public animeController(ru.egorkaaaa.demo.Services.AnimeServiceImpl animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public ResponseEntity<Collection<anime>> getAllAnimeRequest() {
        try {
            Collection<anime> animes = animeService.getAllAnime();
            logger.info("All anime received successfully");
            return new ResponseEntity<>(animes, HttpStatus.FOUND);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/post/new-anime")
    public ResponseEntity<anime> createNewAnime(@ModelAttribute anime anime) {
        try {
            animeService.createNewAnime(anime);
            logger.info("Anime created successfully");
            return new ResponseEntity<>(anime, HttpStatus.CREATED);
        }
        catch (Exception e) {
            logger.error(e.getClass().getName());
            logger.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("{anime-name}/delete")
    public ResponseEntity<anime> deleteAnimeRequest(@PathVariable String animeName ) {

    }
}
