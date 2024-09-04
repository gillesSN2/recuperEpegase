package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedLettreMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedLettreMedicalRepository extends JpaRepository<MedLettreMedical, Long>, JpaSpecificationExecutor<MedLettreMedical> {

}