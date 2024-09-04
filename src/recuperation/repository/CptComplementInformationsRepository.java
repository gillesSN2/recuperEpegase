package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptComplementInformations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptComplementInformationsRepository extends JpaRepository<CptComplementInformations, Long>, JpaSpecificationExecutor<CptComplementInformations> {

}