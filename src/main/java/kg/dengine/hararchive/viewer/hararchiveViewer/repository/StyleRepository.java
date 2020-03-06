package kg.dengine.hararchive.viewer.hararchiveViewer.repository;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.StyleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StyleRepository extends CrudRepository<StyleEntity, Integer> {
    @Query(
            value = "select count(*) from allsong.\"all\" where ?1 = ANY (style_all_arr)",
            nativeQuery = true)
    Integer nativeCountStyle(Integer style);

    List<StyleEntity> findByName(String name);


    @Query(
            value = "select * from allsong.\"all\" where ?1 = ANY (style_all_arr)",
            nativeQuery = true)
    List<AllEntity> getAllByStyle(Integer style);



    StyleEntity findByIdIs(Integer style);
    StyleEntity findByNameIs(String style);

    List<StyleEntity> findByRootFolderIs(String rootFolder);

    List<StyleEntity> findAllByOrderByIdAsc();
    List<StyleEntity> findAllByOrderByNameAsc();
    List<StyleEntity> findAllByOrderByRootFolderAsc();
}
