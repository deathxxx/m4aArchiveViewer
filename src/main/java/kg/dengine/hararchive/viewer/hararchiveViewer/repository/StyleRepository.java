package kg.dengine.hararchive.viewer.hararchiveViewer.repository;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.StyleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface StyleRepository extends CrudRepository<StyleEntity, Integer> {
    @Query(
            value = "select count(*) from allsong.\"all\" where ?1 = ANY (style_all_arr)",
            nativeQuery = true)
    Integer nativeCountStyle(Integer style);

    List<StyleEntity> findByName(String name);
}
