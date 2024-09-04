package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptJournauxComptables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptJournauxComptablesRepository extends JpaRepository<CptJournauxComptables, Long>, JpaSpecificationExecutor<CptJournauxComptables> {

}