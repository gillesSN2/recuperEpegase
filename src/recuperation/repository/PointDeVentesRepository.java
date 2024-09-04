package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PointDeVentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PointDeVentesRepository extends JpaRepository<PointDeVentes, Long>, JpaSpecificationExecutor<PointDeVentes> {

}