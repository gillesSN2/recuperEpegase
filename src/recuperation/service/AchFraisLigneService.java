package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFraisLigne;
import com.yewi.yewicore.recuperation.dtos.AchFraisLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchFraisLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchFraisLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFraisLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFraisLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFraisLigneService {

    @Autowired
    private AchFraisLigneRepository achFraisLigneRepository;

    public Long save(AchFraisLigneVO vO) {
        AchFraisLigne bean = new AchFraisLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achFraisLigneRepository.save(bean);
        return bean.getFsfligId();
    }

    public void delete(Long id) {
        achFraisLigneRepository.deleteById(id);
    }

    public void update(Long id, AchFraisLigneUpdateVO vO) {
        AchFraisLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFraisLigneRepository.save(bean);
    }

    public AchFraisLigneDTO getById(Long id) {
        AchFraisLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFraisLigneDTO> query(AchFraisLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFraisLigneDTO toDTO(AchFraisLigne original) {
        AchFraisLigneDTO bean = new AchFraisLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFraisLigne requireOne(Long id) {
        return achFraisLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
