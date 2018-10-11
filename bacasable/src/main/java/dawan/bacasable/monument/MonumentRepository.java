package dawan.bacasable.monument;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MonumentRepository  extends CrudRepository<Monument,Integer> {

}
