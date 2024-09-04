package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesGrh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesGrhRepository extends JpaRepository<PaySalariesGrh, Long>, JpaSpecificationExecutor<PaySalariesGrh> {

}