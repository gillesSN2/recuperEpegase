package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.ImmBienTravauxLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImmBienTravauxLigneRepository extends JpaRepository<ImmBienTravauxLigne, Long>, JpaSpecificationExecutor<ImmBienTravauxLigne> {

}