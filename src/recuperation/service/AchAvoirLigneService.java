package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchAvoirLigne;
import com.yewi.yewicore.recuperation.dtos.AchAvoirLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchAvoirLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchAvoirLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchAvoirLigneService {

    @Autowired
    private AchAvoirLigneRepository achAvoirLigneRepository;

    public Long save(AchAvoirLigneVO vO) {
        AchAvoirLigne bean = new AchAvoirLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achAvoirLigneRepository.save(bean);
        return bean.getAvfligId();
    }

    public void delete(Long id) {
        achAvoirLigneRepository.deleteById(id);
    }

    public void update(Long id, AchAvoirLigneUpdateVO vO) {
        AchAvoirLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achAvoirLigneRepository.save(bean);
    }

    public AchAvoirLigneDTO getById(Long id) {
        AchAvoirLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchAvoirLigneDTO> query(AchAvoirLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchAvoirLigneDTO toDTO(AchAvoirLigne original) {
        AchAvoirLigneDTO bean = new AchAvoirLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchAvoirLigne requireOne(Long id) {
        return achAvoirLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
