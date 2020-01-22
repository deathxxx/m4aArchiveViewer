package kg.dengine.hararchive.viewer.hararchiveViewer.repository;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AllSongRepository extends CrudRepository<AllEntity, Long> {
    List<AllEntity> findByTrack(String track);
    List<AllEntity> findByTrackContains(String track);
}
