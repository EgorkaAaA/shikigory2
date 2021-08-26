package ru.egorkaaaa.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.egorkaaaa.demo.Entities.anime;
import ru.egorkaaaa.demo.Exceptions.animeAllReadyExistsException;
import ru.egorkaaaa.demo.Exceptions.animeNotFoundException;
import ru.egorkaaaa.demo.Repositories.animeRepo;
import ru.egorkaaaa.demo.Services.Int.animeServiceInterface;

import java.util.Collection;

@Service
public class AnimeServiceImpl implements animeServiceInterface {
    private final animeRepo animeRepo;

    @Autowired
    public AnimeServiceImpl(ru.egorkaaaa.demo.Repositories.animeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    public void createNewAnime(anime anime) throws animeAllReadyExistsException {
        if(animeRepo.findByAnimeName(anime.getAnimeName()) == null) {
            animeRepo.save(anime);
        }
        else {
            throw new animeAllReadyExistsException(String.format("Anime with name %s all ready exists",anime.getAnimeName()));
        }
    }

//    public

    public Collection<anime> getAllAnime() {
        return animeRepo.findAll();
    }

    @Override
    public void deleteAnimeByAnimeName(String animeName) throws animeNotFoundException {
        anime anime = animeRepo.findByAnimeName(animeName);
        if(anime != null) {
            animeRepo.deleteAllAnimeInCharacterList(animeName);
            animeRepo.deleteAllAnimeInAnimeList(animeName);
            animeRepo.delete(anime);
        }
        else {
            throw new animeNotFoundException(String.format("the %s you wanted to delete was not found",animeName));
        }
    }

    @Override
    public void updateAnimeBuAnimeName(String lastAnimeName, anime updatedAnime) throws animeNotFoundException {
        anime anime = animeRepo.findByAnimeName(lastAnimeName);
        if(anime != null) {
            animeRepo.save(updatedAnime);
        }
        else {
            throw new animeNotFoundException(String.format("the %s you wanted to update was not found",lastAnimeName));
        }
    }

    @Override
    public anime findAnimeByAnimeName(String animeName) throws animeNotFoundException {
        return null;
    }
}
