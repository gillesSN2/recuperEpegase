package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcExercicesParc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcExercicesParcRepository extends JpaRepository<PrcExercicesParc, Long>, JpaSpecificationExecutor<PrcExercicesParc> {

}