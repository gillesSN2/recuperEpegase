package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmBaremes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmBaremesRepository extends JpaRepository<CmmBaremes, Long>, JpaSpecificationExecutor<CmmBaremes> {

}