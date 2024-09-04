package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PaySalariesPointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaySalariesPointageRepository extends JpaRepository<PaySalariesPointage, Long>, JpaSpecificationExecutor<PaySalariesPointage> {

}