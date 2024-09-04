package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteCampagneEntete;
import com.yewi.yewicore.recuperation.dtos.VteCampagneEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteCampagneEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteCampagneEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteCampagneEnteteService {

    @Autowired
    private VteCampagneEnteteRepository vteCampagneEnteteRepository;

    public Long save(VteCampagneEnteteVO vO) {
        VteCampagneEntete bean = new VteCampagneEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteCampagneEnteteRepository.save(bean);
        return bean.getCamId();
    }

    public void delete(Long id) {
        vteCampagneEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteCampagneEnteteUpdateVO vO) {
        VteCampagneEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteCampagneEnteteRepository.save(bean);
    }

    public VteCampagneEnteteDTO getById(Long id) {
        VteCampagneEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteCampagneEnteteDTO> query(VteCampagneEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteCampagneEnteteDTO toDTO(VteCampagneEntete original) {
        VteCampagneEnteteDTO bean = new VteCampagneEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteCampagneEntete requireOne(Long id) {
        return vteCampagneEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
