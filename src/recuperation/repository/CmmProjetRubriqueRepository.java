package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmProjetRubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmProjetRubriqueRepository extends JpaRepository<CmmProjetRubrique, Long>, JpaSpecificationExecutor<CmmProjetRubrique> {

}