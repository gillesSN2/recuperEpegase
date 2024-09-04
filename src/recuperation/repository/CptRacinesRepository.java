package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptRacines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptRacinesRepository extends JpaRepository<CptRacines, Long>, JpaSpecificationExecutor<CptRacines> {

}