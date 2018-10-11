package dawan.bacasable.monument;



import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MonumentRepository  extends PagingAndSortingRepository<Monument,Integer> {
	
	@Query("FROM Monument m WHERE m.nom like %:nom%")
	Page<Monument> findByDescription(String nom, Pageable p );
	

	

}
