package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchBonSortieLigne;
import com.yewi.yewicore.recuperation.dtos.AchBonSortieLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchBonSortieLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchBonSortieLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchBonSortieLigneService {

    @Autowired
    private AchBonSortieLigneRepository achBonSortieLigneRepository;

    public Long save(AchBonSortieLigneVO vO) {
        AchBonSortieLigne bean = new AchBonSortieLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achBonSortieLigneRepository.save(bean);
        return bean.getBouligId();
    }

    public void delete(Long id) {
        achBonSortieLigneRepository.deleteById(id);
    }

    public void update(Long id, AchBonSortieLigneUpdateVO vO) {
        AchBonSortieLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achBonSortieLigneRepository.save(bean);
    }

    public AchBonSortieLigneDTO getById(Long id) {
        AchBonSortieLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchBonSortieLigneDTO> query(AchBonSortieLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchBonSortieLigneDTO toDTO(AchBonSortieLigne original) {
        AchBonSortieLigneDTO bean = new AchBonSortieLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchBonSortieLigne requireOne(Long id) {
        return achBonSortieLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
