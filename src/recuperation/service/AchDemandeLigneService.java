package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchDemandeLigne;
import com.yewi.yewicore.recuperation.dtos.AchDemandeLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchDemandeLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchDemandeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchDemandeLigneService {

    @Autowired
    private AchDemandeLigneRepository achDemandeLigneRepository;

    public Long save(AchDemandeLigneVO vO) {
        AchDemandeLigne bean = new AchDemandeLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achDemandeLigneRepository.save(bean);
        return bean.getDemligId();
    }

    public void delete(Long id) {
        achDemandeLigneRepository.deleteById(id);
    }

    public void update(Long id, AchDemandeLigneUpdateVO vO) {
        AchDemandeLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achDemandeLigneRepository.save(bean);
    }

    public AchDemandeLigneDTO getById(Long id) {
        AchDemandeLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchDemandeLigneDTO> query(AchDemandeLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchDemandeLigneDTO toDTO(AchDemandeLigne original) {
        AchDemandeLigneDTO bean = new AchDemandeLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchDemandeLigne requireOne(Long id) {
        return achDemandeLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
