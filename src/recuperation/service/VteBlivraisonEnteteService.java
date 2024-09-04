package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBlivraisonEntete;
import com.yewi.yewicore.recuperation.dtos.VteBlivraisonEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteBlivraisonEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBlivraisonEnteteService {

    @Autowired
    private VteBlivraisonEnteteRepository vteBlivraisonEnteteRepository;

    public Long save(VteBlivraisonEnteteVO vO) {
        VteBlivraisonEntete bean = new VteBlivraisonEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBlivraisonEnteteRepository.save(bean);
        return bean.getBlvId();
    }

    public void delete(Long id) {
        vteBlivraisonEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteBlivraisonEnteteUpdateVO vO) {
        VteBlivraisonEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBlivraisonEnteteRepository.save(bean);
    }

    public VteBlivraisonEnteteDTO getById(Long id) {
        VteBlivraisonEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBlivraisonEnteteDTO> query(VteBlivraisonEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBlivraisonEnteteDTO toDTO(VteBlivraisonEntete original) {
        VteBlivraisonEnteteDTO bean = new VteBlivraisonEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBlivraisonEntete requireOne(Long id) {
        return vteBlivraisonEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
