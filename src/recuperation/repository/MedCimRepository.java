package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedCim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedCimRepository extends JpaRepository<MedCim, Long>, JpaSpecificationExecutor<MedCim> {

}