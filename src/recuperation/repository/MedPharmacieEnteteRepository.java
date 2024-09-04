package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedPharmacieEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedPharmacieEnteteRepository extends JpaRepository<MedPharmacieEntete, Long>, JpaSpecificationExecutor<MedPharmacieEntete> {

}