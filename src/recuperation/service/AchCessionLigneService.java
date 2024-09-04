package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchCessionLigne;
import com.yewi.yewicore.recuperation.dtos.AchCessionLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchCessionLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchCessionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCessionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCessionLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchCessionLigneService {

    @Autowired
    private AchCessionLigneRepository achCessionLigneRepository;

    public Long save(AchCessionLigneVO vO) {
        AchCessionLigne bean = new AchCessionLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achCessionLigneRepository.save(bean);
        return bean.getCesligId();
    }

    public void delete(Long id) {
        achCessionLigneRepository.deleteById(id);
    }

    public void update(Long id, AchCessionLigneUpdateVO vO) {
        AchCessionLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achCessionLigneRepository.save(bean);
    }

    public AchCessionLigneDTO getById(Long id) {
        AchCessionLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchCessionLigneDTO> query(AchCessionLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchCessionLigneDTO toDTO(AchCessionLigne original) {
        AchCessionLigneDTO bean = new AchCessionLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchCessionLigne requireOne(Long id) {
        return achCessionLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
