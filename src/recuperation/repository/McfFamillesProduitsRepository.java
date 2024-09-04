package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.McfFamillesProduits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface McfFamillesProduitsRepository extends JpaRepository<McfFamillesProduits, Long>, JpaSpecificationExecutor<McfFamillesProduits> {

}