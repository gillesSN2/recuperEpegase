package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedCma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedCmaRepository extends JpaRepository<MedCma, Long>, JpaSpecificationExecutor<MedCma> {

}