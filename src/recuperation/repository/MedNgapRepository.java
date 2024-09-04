package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.MedNgap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedNgapRepository extends JpaRepository<MedNgap, Long>, JpaSpecificationExecutor<MedNgap> {

}