package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptAmortissements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptAmortissementsRepository extends JpaRepository<CptAmortissements, Long>, JpaSpecificationExecutor<CptAmortissements> {

}