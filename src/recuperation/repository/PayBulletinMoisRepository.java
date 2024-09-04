package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayBulletinMois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayBulletinMoisRepository extends JpaRepository<PayBulletinMois, Long>, JpaSpecificationExecutor<PayBulletinMois> {

}