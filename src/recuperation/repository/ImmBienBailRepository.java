package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.ImmBienBail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImmBienBailRepository extends JpaRepository<ImmBienBail, Long>, JpaSpecificationExecutor<ImmBienBail> {

}