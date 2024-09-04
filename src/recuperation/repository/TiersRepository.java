package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Tiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TiersRepository extends JpaRepository<Tiers, Long>, JpaSpecificationExecutor<Tiers> {

}