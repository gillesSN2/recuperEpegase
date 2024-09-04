package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBcommandeEntete;
import com.yewi.yewicore.recuperation.dtos.VteBcommandeEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteBcommandeEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteBcommandeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBcommandeEnteteService {

    @Autowired
    private VteBcommandeEnteteRepository vteBcommandeEnteteRepository;

    public Long save(VteBcommandeEnteteVO vO) {
        VteBcommandeEntete bean = new VteBcommandeEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBcommandeEnteteRepository.save(bean);
        return bean.getBcmId();
    }

    public void delete(Long id) {
        vteBcommandeEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteBcommandeEnteteUpdateVO vO) {
        VteBcommandeEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBcommandeEnteteRepository.save(bean);
    }

    public VteBcommandeEnteteDTO getById(Long id) {
        VteBcommandeEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBcommandeEnteteDTO> query(VteBcommandeEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBcommandeEnteteDTO toDTO(VteBcommandeEntete original) {
        VteBcommandeEnteteDTO bean = new VteBcommandeEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBcommandeEntete requireOne(Long id) {
        return vteBcommandeEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
