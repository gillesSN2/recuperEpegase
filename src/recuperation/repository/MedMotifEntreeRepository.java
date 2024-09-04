package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedMotifEntree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedMotifEntreeRepository extends JpaRepository<MedMotifEntree, Long>, JpaSpecificationExecutor<MedMotifEntree> {

}