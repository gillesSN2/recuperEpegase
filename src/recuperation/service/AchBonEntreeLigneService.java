package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchBonEntreeLigne;
import com.yewi.yewicore.recuperation.dtos.AchBonEntreeLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchBonEntreeLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchBonEntreeLigneService {

    @Autowired
    private AchBonEntreeLigneRepository achBonEntreeLigneRepository;

    public Long save(AchBonEntreeLigneVO vO) {
        AchBonEntreeLigne bean = new AchBonEntreeLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achBonEntreeLigneRepository.save(bean);
        return bean.getBinligId();
    }

    public void delete(Long id) {
        achBonEntreeLigneRepository.deleteById(id);
    }

    public void update(Long id, AchBonEntreeLigneUpdateVO vO) {
        AchBonEntreeLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achBonEntreeLigneRepository.save(bean);
    }

    public AchBonEntreeLigneDTO getById(Long id) {
        AchBonEntreeLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchBonEntreeLigneDTO> query(AchBonEntreeLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchBonEntreeLigneDTO toDTO(AchBonEntreeLigne original) {
        AchBonEntreeLigneDTO bean = new AchBonEntreeLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchBonEntreeLigne requireOne(Long id) {
        return achBonEntreeLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
