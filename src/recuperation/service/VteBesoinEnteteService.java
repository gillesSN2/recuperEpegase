package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBesoinEntete;
import com.yewi.yewicore.recuperation.dtos.VteBesoinEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteBesoinEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteBesoinEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBesoinEnteteService {

    @Autowired
    private VteBesoinEnteteRepository vteBesoinEnteteRepository;

    public Long save(VteBesoinEnteteVO vO) {
        VteBesoinEntete bean = new VteBesoinEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBesoinEnteteRepository.save(bean);
        return bean.getBesId();
    }

    public void delete(Long id) {
        vteBesoinEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteBesoinEnteteUpdateVO vO) {
        VteBesoinEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBesoinEnteteRepository.save(bean);
    }

    public VteBesoinEnteteDTO getById(Long id) {
        VteBesoinEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBesoinEnteteDTO> query(VteBesoinEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBesoinEnteteDTO toDTO(VteBesoinEntete original) {
        VteBesoinEnteteDTO bean = new VteBesoinEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBesoinEntete requireOne(Long id) {
        return vteBesoinEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
