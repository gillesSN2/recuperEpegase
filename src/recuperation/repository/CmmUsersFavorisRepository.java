package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmUsersFavoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmUsersFavorisRepository extends JpaRepository<CmmUsersFavoris, Long>, JpaSpecificationExecutor<CmmUsersFavoris> {

}