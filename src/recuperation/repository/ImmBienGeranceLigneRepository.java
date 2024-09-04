package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.ImmBienGeranceLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImmBienGeranceLigneRepository extends JpaRepository<ImmBienGeranceLigne, Long>, JpaSpecificationExecutor<ImmBienGeranceLigne> {

}