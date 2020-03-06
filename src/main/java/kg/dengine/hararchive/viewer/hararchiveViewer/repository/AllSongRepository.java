package kg.dengine.hararchive.viewer.hararchiveViewer.repository;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AllSongRepository extends CrudRepository<AllEntity, Long> {
    AllEntity findByTrackIs(String track);
    List<AllEntity> findByTrack(String track);
    List<AllEntity> findByTrackContains(String track);
    List<AllEntity> findByTrackContainsOrderByVoteUpAsc(String track);
    List<AllEntity> findByTrackContainsOrderByVoteUpDesc(String track);
    AllEntity findByTrackId(Long id);
    List<AllEntity> findAllByStyleAllContains(String style);
    List<AllEntity> findByArtistId(Long artistId);

    @Query(
            value = "select * from allsong.\"all\" where ?1 = ANY (style_all_arr)",
            nativeQuery = true)
    List<AllEntity> getAllByStyle(Integer style);

    @Query(
            value = "select * from allsong.\"all\" where ?1 = ANY (style_all_arr) and folder is null",
            nativeQuery = true)
    List<AllEntity> getAllByStyleNoFolder(Integer style);




    List<AllEntity> findByTrackContainsOrderByVoteUp(String track);
    List<AllEntity> findByTrackContainsOrderByVoteDown(String track);

    //sorting
    List<AllEntity> findAllByStyleAllContainsOrderByArtistIdAsc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByTrackIdAsc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByDisplayArtistAsc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByTrackAsc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByStyleAsc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByVoteUpAsc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByVoteUpDesc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByVoteDownAsc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByVoteDownDesc(String style);

    List<AllEntity> findAllByStyleAllContainsOrderByTrackIdDesc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByDisplayArtistDesc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByTrackDesc(String style);
    List<AllEntity> findAllByStyleAllContainsOrderByStyleDesc(String style);


}
