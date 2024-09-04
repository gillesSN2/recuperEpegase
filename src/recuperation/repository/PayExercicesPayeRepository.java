package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayExercicesPaye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayExercicesPayeRepository extends JpaRepository<PayExercicesPaye, Long>, JpaSpecificationExecutor<PayExercicesPaye> {

}