package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayBulletinLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayBulletinLigneRepository extends JpaRepository<PayBulletinLigne, Long>, JpaSpecificationExecutor<PayBulletinLigne> {

}