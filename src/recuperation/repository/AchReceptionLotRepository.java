package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.AchReceptionLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AchReceptionLotRepository extends JpaRepository<AchReceptionLot, Long>, JpaSpecificationExecutor<AchReceptionLot> {

}