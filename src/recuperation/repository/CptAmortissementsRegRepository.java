package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptAmortissementsReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptAmortissementsRegRepository extends JpaRepository<CptAmortissementsReg, Long>, JpaSpecificationExecutor<CptAmortissementsReg> {

}