package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptLoyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptLoyerRepository extends JpaRepository<CptLoyer, Long>, JpaSpecificationExecutor<CptLoyer> {

}