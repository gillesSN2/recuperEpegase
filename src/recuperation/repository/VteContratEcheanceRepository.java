package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteContratEcheance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteContratEcheanceRepository extends JpaRepository<VteContratEcheance, Long>, JpaSpecificationExecutor<VteContratEcheance> {

}