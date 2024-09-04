package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CmmSms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmmSmsRepository extends JpaRepository<CmmSms, Long>, JpaSpecificationExecutor<CmmSms> {

}