package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmSignature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmSignatureRepository extends JpaRepository<CmmSignature, Long>, JpaSpecificationExecutor<CmmSignature> {

}