package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiBonEntree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiBonEntreeRepository extends JpaRepository<CaiBonEntree, Long>, JpaSpecificationExecutor<CaiBonEntree> {

}