package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteChargementEntete;
import com.yewi.yewicore.recuperation.dtos.VteChargementEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteChargementEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteChargementEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteChargementEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteChargementEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteChargementEnteteService {

    @Autowired
    private VteChargementEnteteRepository vteChargementEnteteRepository;

    public Long save(VteChargementEnteteVO vO) {
        VteChargementEntete bean = new VteChargementEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteChargementEnteteRepository.save(bean);
        return bean.getChamobId();
    }

    public void delete(Long id) {
        vteChargementEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteChargementEnteteUpdateVO vO) {
        VteChargementEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteChargementEnteteRepository.save(bean);
    }

    public VteChargementEnteteDTO getById(Long id) {
        VteChargementEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteChargementEnteteDTO> query(VteChargementEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteChargementEnteteDTO toDTO(VteChargementEntete original) {
        VteChargementEnteteDTO bean = new VteChargementEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteChargementEntete requireOne(Long id) {
        return vteChargementEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
