package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedSpecialitesMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedSpecialitesMedicalRepository extends JpaRepository<MedSpecialitesMedical, Long>, JpaSpecificationExecutor<MedSpecialitesMedical> {

}