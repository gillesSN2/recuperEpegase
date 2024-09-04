package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptTabFormule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptTabFormuleRepository extends JpaRepository<CptTabFormule, Long>, JpaSpecificationExecutor<CptTabFormule> {

}