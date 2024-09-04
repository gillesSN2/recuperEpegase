package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CptTabResultats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CptTabResultatsRepository extends JpaRepository<CptTabResultats, Long>, JpaSpecificationExecutor<CptTabResultats> {

}