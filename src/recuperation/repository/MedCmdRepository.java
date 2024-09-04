package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedCmd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedCmdRepository extends JpaRepository<MedCmd, Long>, JpaSpecificationExecutor<MedCmd> {

}