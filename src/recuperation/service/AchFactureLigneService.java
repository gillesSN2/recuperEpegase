package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchFactureLigne;
import com.yewi.yewicore.recuperation.dtos.AchFactureLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchFactureLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchFactureLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFactureLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFactureLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchFactureLigneService {

    @Autowired
    private AchFactureLigneRepository achFactureLigneRepository;

    public Long save(AchFactureLigneVO vO) {
        AchFactureLigne bean = new AchFactureLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achFactureLigneRepository.save(bean);
        return bean.getFcfligId();
    }

    public void delete(Long id) {
        achFactureLigneRepository.deleteById(id);
    }

    public void update(Long id, AchFactureLigneUpdateVO vO) {
        AchFactureLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achFactureLigneRepository.save(bean);
    }

    public AchFactureLigneDTO getById(Long id) {
        AchFactureLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchFactureLigneDTO> query(AchFactureLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchFactureLigneDTO toDTO(AchFactureLigne original) {
        AchFactureLigneDTO bean = new AchFactureLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchFactureLigne requireOne(Long id) {
        return achFactureLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
