package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteSimulationEntete;
import com.yewi.yewicore.recuperation.dtos.VteSimulationEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteSimulationEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteSimulationEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteSimulationEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteSimulationEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteSimulationEnteteService {

    @Autowired
    private VteSimulationEnteteRepository vteSimulationEnteteRepository;

    public Long save(VteSimulationEnteteVO vO) {
        VteSimulationEntete bean = new VteSimulationEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteSimulationEnteteRepository.save(bean);
        return bean.getSimcrtId();
    }

    public void delete(Long id) {
        vteSimulationEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteSimulationEnteteUpdateVO vO) {
        VteSimulationEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteSimulationEnteteRepository.save(bean);
    }

    public VteSimulationEnteteDTO getById(Long id) {
        VteSimulationEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteSimulationEnteteDTO> query(VteSimulationEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteSimulationEnteteDTO toDTO(VteSimulationEntete original) {
        VteSimulationEnteteDTO bean = new VteSimulationEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteSimulationEntete requireOne(Long id) {
        return vteSimulationEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
