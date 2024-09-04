package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchInventaireLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchInventaireLigneRepository extends JpaRepository<AchInventaireLigne, Long>, JpaSpecificationExecutor<AchInventaireLigne> {

}