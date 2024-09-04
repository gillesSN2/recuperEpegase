package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchProcessLigne;
import com.yewi.yewicore.recuperation.dtos.AchProcessLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchProcessLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchProcessLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchProcessLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchProcessLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchProcessLigneService {

    @Autowired
    private AchProcessLigneRepository achProcessLigneRepository;

    public Long save(AchProcessLigneVO vO) {
        AchProcessLigne bean = new AchProcessLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achProcessLigneRepository.save(bean);
        return bean.getProcesligId();
    }

    public void delete(Long id) {
        achProcessLigneRepository.deleteById(id);
    }

    public void update(Long id, AchProcessLigneUpdateVO vO) {
        AchProcessLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achProcessLigneRepository.save(bean);
    }

    public AchProcessLigneDTO getById(Long id) {
        AchProcessLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchProcessLigneDTO> query(AchProcessLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchProcessLigneDTO toDTO(AchProcessLigne original) {
        AchProcessLigneDTO bean = new AchProcessLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchProcessLigne requireOne(Long id) {
        return achProcessLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
