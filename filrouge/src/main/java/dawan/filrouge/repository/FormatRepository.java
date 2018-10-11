package dawan.filrouge.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dawan.filrouge.modele.Format;

@Transactional
@Repository
public interface FormatRepository  extends PagingAndSortingRepository<Format,String> {
		
}



