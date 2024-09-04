package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBretourEntete;
import com.yewi.yewicore.recuperation.dtos.VteBretourEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteBretourEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteBretourEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBretourEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBretourEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBretourEnteteService {

    @Autowired
    private VteBretourEnteteRepository vteBretourEnteteRepository;

    public Long save(VteBretourEnteteVO vO) {
        VteBretourEntete bean = new VteBretourEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBretourEnteteRepository.save(bean);
        return bean.getBrtId();
    }

    public void delete(Long id) {
        vteBretourEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteBretourEnteteUpdateVO vO) {
        VteBretourEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBretourEnteteRepository.save(bean);
    }

    public VteBretourEnteteDTO getById(Long id) {
        VteBretourEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBretourEnteteDTO> query(VteBretourEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBretourEnteteDTO toDTO(VteBretourEntete original) {
        VteBretourEnteteDTO bean = new VteBretourEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBretourEntete requireOne(Long id) {
        return vteBretourEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
