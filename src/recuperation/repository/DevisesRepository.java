package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Devises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DevisesRepository extends JpaRepository<Devises, String>, JpaSpecificationExecutor<Devises> {

}