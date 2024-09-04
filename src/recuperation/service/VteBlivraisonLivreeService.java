package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBlivraisonLivree;
import com.yewi.yewicore.recuperation.dtos.VteBlivraisonLivreeDTO;
import com.yewi.yewicore.recuperation.repository.VteBlivraisonLivreeRepository;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLivreeQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLivreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLivreeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBlivraisonLivreeService {

    @Autowired
    private VteBlivraisonLivreeRepository vteBlivraisonLivreeRepository;

    public Long save(VteBlivraisonLivreeVO vO) {
        VteBlivraisonLivree bean = new VteBlivraisonLivree();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBlivraisonLivreeRepository.save(bean);
        return bean.getBlvlivId();
    }

    public void delete(Long id) {
        vteBlivraisonLivreeRepository.deleteById(id);
    }

    public void update(Long id, VteBlivraisonLivreeUpdateVO vO) {
        VteBlivraisonLivree bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBlivraisonLivreeRepository.save(bean);
    }

    public VteBlivraisonLivreeDTO getById(Long id) {
        VteBlivraisonLivree original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBlivraisonLivreeDTO> query(VteBlivraisonLivreeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBlivraisonLivreeDTO toDTO(VteBlivraisonLivree original) {
        VteBlivraisonLivreeDTO bean = new VteBlivraisonLivreeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBlivraisonLivree requireOne(Long id) {
        return vteBlivraisonLivreeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
