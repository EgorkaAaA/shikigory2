package ru.egorkaaaa.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.egorkaaaa.demo.Entities.anime;

@Repository
public interface animeRepo extends JpaRepository<anime,String> {
    anime findByAnimeName(String s);

    @Query(
            value = "DELETE FROM character_list where anime_name = :animeName",
            nativeQuery = true)
    void deleteAllAnimeInCharacterList(@Param("animeName") String animeName);

    @Query(
            value = "DELETE FROM anime_list where anime_name = :animeName",
            nativeQuery = true)
    void deleteAllAnimeInAnimeList(@Param("animeName") String animeName);
}
