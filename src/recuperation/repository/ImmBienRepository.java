package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.ImmBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImmBienRepository extends JpaRepository<ImmBien, Long>, JpaSpecificationExecutor<ImmBien> {

}