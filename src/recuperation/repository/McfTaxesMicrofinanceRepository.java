package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.McfTaxesMicrofinance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface McfTaxesMicrofinanceRepository extends JpaRepository<McfTaxesMicrofinance, Long>, JpaSpecificationExecutor<McfTaxesMicrofinance> {

}