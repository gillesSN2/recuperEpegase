package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteExercicesVentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteExercicesVentesRepository extends JpaRepository<VteExercicesVentes, Long>, JpaSpecificationExecutor<VteExercicesVentes> {

}