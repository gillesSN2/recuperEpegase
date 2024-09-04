package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteChargementFrais;
import com.yewi.yewicore.recuperation.dtos.VteChargementFraisDTO;
import com.yewi.yewicore.recuperation.repository.VteChargementFraisRepository;
import com.yewi.yewicore.recuperation.vo.VteChargementFraisQueryVO;
import com.yewi.yewicore.recuperation.vo.VteChargementFraisUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteChargementFraisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteChargementFraisService {

    @Autowired
    private VteChargementFraisRepository vteChargementFraisRepository;

    public Long save(VteChargementFraisVO vO) {
        VteChargementFrais bean = new VteChargementFrais();
        BeanUtils.copyProperties(vO, bean);
        bean = vteChargementFraisRepository.save(bean);
        return bean.getChafraId();
    }

    public void delete(Long id) {
        vteChargementFraisRepository.deleteById(id);
    }

    public void update(Long id, VteChargementFraisUpdateVO vO) {
        VteChargementFrais bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteChargementFraisRepository.save(bean);
    }

    public VteChargementFraisDTO getById(Long id) {
        VteChargementFrais original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteChargementFraisDTO> query(VteChargementFraisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteChargementFraisDTO toDTO(VteChargementFrais original) {
        VteChargementFraisDTO bean = new VteChargementFraisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteChargementFrais requireOne(Long id) {
        return vteChargementFraisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
