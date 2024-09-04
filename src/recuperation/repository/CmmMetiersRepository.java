package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmMetiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmMetiersRepository extends JpaRepository<CmmMetiers, Long>, JpaSpecificationExecutor<CmmMetiers> {

}