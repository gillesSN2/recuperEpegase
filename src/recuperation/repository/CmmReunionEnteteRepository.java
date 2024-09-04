package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmReunionEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmReunionEnteteRepository extends JpaRepository<CmmReunionEntete, Long>, JpaSpecificationExecutor<CmmReunionEntete> {

}