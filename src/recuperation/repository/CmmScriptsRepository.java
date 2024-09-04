package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmScripts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmScriptsRepository extends JpaRepository<CmmScripts, Long>, JpaSpecificationExecutor<CmmScripts> {

}