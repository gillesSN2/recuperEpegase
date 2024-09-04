package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PrcMotifEntree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrcMotifEntreeRepository extends JpaRepository<PrcMotifEntree, Long>, JpaSpecificationExecutor<PrcMotifEntree> {

}