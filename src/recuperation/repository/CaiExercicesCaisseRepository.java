package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiExercicesCaisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiExercicesCaisseRepository extends JpaRepository<CaiExercicesCaisse, Long>, JpaSpecificationExecutor<CaiExercicesCaisse> {

}