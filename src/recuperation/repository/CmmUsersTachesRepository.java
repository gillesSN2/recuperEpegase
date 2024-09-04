package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmUsersTaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmUsersTachesRepository extends JpaRepository<CmmUsersTaches, Long>, JpaSpecificationExecutor<CmmUsersTaches> {

}