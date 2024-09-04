package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiCaissesMois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiCaissesMoisRepository extends JpaRepository<CaiCaissesMois, Long>, JpaSpecificationExecutor<CaiCaissesMois> {

}