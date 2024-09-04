package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptAmortissementsTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptAmortissementsTabRepository extends JpaRepository<CptAmortissementsTab, Long>, JpaSpecificationExecutor<CptAmortissementsTab> {

}