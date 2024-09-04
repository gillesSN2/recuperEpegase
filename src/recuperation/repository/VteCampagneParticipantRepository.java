package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteCampagneParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteCampagneParticipantRepository extends JpaRepository<VteCampagneParticipant, Long>, JpaSpecificationExecutor<VteCampagneParticipant> {

}