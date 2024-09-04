package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiReglements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiReglementsRepository extends JpaRepository<CaiReglements, Long>, JpaSpecificationExecutor<CaiReglements> {

}