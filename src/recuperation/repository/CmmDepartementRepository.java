package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmDepartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmDepartementRepository extends JpaRepository<CmmDepartement, Long>, JpaSpecificationExecutor<CmmDepartement> {

}