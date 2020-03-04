package kg.dengine.hararchive.viewer.hararchiveViewer.repository;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.ArtistEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<ArtistEntity, Long>
{
    List<ArtistEntity> findByDisplayArtistContains(String artist);
}