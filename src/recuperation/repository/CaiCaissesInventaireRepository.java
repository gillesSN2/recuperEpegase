package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiCaissesInventaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiCaissesInventaireRepository extends JpaRepository<CaiCaissesInventaire, Long>, JpaSpecificationExecutor<CaiCaissesInventaire> {

}