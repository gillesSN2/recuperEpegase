package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchRetourLigne;
import com.yewi.yewicore.recuperation.dtos.AchRetourLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchRetourLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchRetourLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchRetourLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchRetourLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchRetourLigneService {

    @Autowired
    private AchRetourLigneRepository achRetourLigneRepository;

    public Long save(AchRetourLigneVO vO) {
        AchRetourLigne bean = new AchRetourLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achRetourLigneRepository.save(bean);
        return bean.getBrfligId();
    }

    public void delete(Long id) {
        achRetourLigneRepository.deleteById(id);
    }

    public void update(Long id, AchRetourLigneUpdateVO vO) {
        AchRetourLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achRetourLigneRepository.save(bean);
    }

    public AchRetourLigneDTO getById(Long id) {
        AchRetourLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchRetourLigneDTO> query(AchRetourLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchRetourLigneDTO toDTO(AchRetourLigne original) {
        AchRetourLigneDTO bean = new AchRetourLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchRetourLigne requireOne(Long id) {
        return achRetourLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
