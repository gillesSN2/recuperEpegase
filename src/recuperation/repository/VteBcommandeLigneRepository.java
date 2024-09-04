package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.VteBcommandeLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VteBcommandeLigneRepository extends JpaRepository<VteBcommandeLigne, Long>, JpaSpecificationExecutor<VteBcommandeLigne> {

}