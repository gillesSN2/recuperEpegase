package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptJournauxMois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptJournauxMoisRepository extends JpaRepository<CptJournauxMois, Long>, JpaSpecificationExecutor<CptJournauxMois> {

}