package dawan.filrouge.repository;

import dawan.filrouge.modele.Image;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image,String>{

@Cacheable("test")
@Query("FROM Image i WHERE i.imageGroupId=:groupId AND i.format.nom=:formatName")
  public Image  findByImageGroupId(@Param("groupId") String groupId, String formatName) ;
}
