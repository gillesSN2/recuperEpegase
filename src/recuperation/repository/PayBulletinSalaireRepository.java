package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.PayBulletinSalaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayBulletinSalaireRepository extends JpaRepository<PayBulletinSalaire, Long>, JpaSpecificationExecutor<PayBulletinSalaire> {

}