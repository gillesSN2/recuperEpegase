package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmTaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmTachesRepository extends JpaRepository<CmmTaches, Long>, JpaSpecificationExecutor<CmmTaches> {

}