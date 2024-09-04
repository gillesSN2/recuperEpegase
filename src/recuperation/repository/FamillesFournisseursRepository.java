package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.FamillesFournisseurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FamillesFournisseursRepository extends JpaRepository<FamillesFournisseurs, Long>, JpaSpecificationExecutor<FamillesFournisseurs> {

}