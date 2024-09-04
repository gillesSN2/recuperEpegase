package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchCommandeLigne;
import com.yewi.yewicore.recuperation.dtos.AchCommandeLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchCommandeLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchCommandeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchCommandeLigneService {

    @Autowired
    private AchCommandeLigneRepository achCommandeLigneRepository;

    public Long save(AchCommandeLigneVO vO) {
        AchCommandeLigne bean = new AchCommandeLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achCommandeLigneRepository.save(bean);
        return bean.getCmdligId();
    }

    public void delete(Long id) {
        achCommandeLigneRepository.deleteById(id);
    }

    public void update(Long id, AchCommandeLigneUpdateVO vO) {
        AchCommandeLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achCommandeLigneRepository.save(bean);
    }

    public AchCommandeLigneDTO getById(Long id) {
        AchCommandeLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchCommandeLigneDTO> query(AchCommandeLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchCommandeLigneDTO toDTO(AchCommandeLigne original) {
        AchCommandeLigneDTO bean = new AchCommandeLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchCommandeLigne requireOne(Long id) {
        return achCommandeLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
