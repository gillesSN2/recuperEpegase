package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmDevise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmDeviseRepository extends JpaRepository<CmmDevise, Integer>, JpaSpecificationExecutor<CmmDevise> {

}