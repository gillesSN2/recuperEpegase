package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedProtocole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedProtocoleRepository extends JpaRepository<MedProtocole, Long>, JpaSpecificationExecutor<MedProtocole> {

}