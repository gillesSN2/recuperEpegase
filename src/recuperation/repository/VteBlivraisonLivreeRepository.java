package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBlivraisonLivree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBlivraisonLivreeRepository extends JpaRepository<VteBlivraisonLivree, Long>, JpaSpecificationExecutor<VteBlivraisonLivree> {

}