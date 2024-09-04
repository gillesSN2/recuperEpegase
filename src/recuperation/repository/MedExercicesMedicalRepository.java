package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedExercicesMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedExercicesMedicalRepository extends JpaRepository<MedExercicesMedical, Long>, JpaSpecificationExecutor<MedExercicesMedical> {

}