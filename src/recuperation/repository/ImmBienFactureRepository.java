package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.ImmBienFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImmBienFactureRepository extends JpaRepository<ImmBienFacture, Long>, JpaSpecificationExecutor<ImmBienFacture> {

}