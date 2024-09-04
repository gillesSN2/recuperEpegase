package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteChargementLigne;
import com.yewi.yewicore.recuperation.dtos.VteChargementLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteChargementLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteChargementLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteChargementLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteChargementLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteChargementLigneService {

    @Autowired
    private VteChargementLigneRepository vteChargementLigneRepository;

    public Long save(VteChargementLigneVO vO) {
        VteChargementLigne bean = new VteChargementLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteChargementLigneRepository.save(bean);
        return bean.getChaligId();
    }

    public void delete(Long id) {
        vteChargementLigneRepository.deleteById(id);
    }

    public void update(Long id, VteChargementLigneUpdateVO vO) {
        VteChargementLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteChargementLigneRepository.save(bean);
    }

    public VteChargementLigneDTO getById(Long id) {
        VteChargementLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteChargementLigneDTO> query(VteChargementLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteChargementLigneDTO toDTO(VteChargementLigne original) {
        VteChargementLigneDTO bean = new VteChargementLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteChargementLigne requireOne(Long id) {
        return vteChargementLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
