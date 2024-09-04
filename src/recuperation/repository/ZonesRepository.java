package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Zones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZonesRepository extends JpaRepository<Zones, Long>, JpaSpecificationExecutor<Zones> {

}