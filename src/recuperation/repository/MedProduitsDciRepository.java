package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedProduitsDci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedProduitsDciRepository extends JpaRepository<MedProduitsDci, Long>, JpaSpecificationExecutor<MedProduitsDci> {

}