package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteFactureLigne;
import com.yewi.yewicore.recuperation.dtos.VteFactureLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteFactureLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteFactureLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFactureLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFactureLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteFactureLigneService {

    @Autowired
    private VteFactureLigneRepository vteFactureLigneRepository;

    public Long save(VteFactureLigneVO vO) {
        VteFactureLigne bean = new VteFactureLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteFactureLigneRepository.save(bean);
        return bean.getFacligId();
    }

    public void delete(Long id) {
        vteFactureLigneRepository.deleteById(id);
    }

    public void update(Long id, VteFactureLigneUpdateVO vO) {
        VteFactureLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteFactureLigneRepository.save(bean);
    }

    public VteFactureLigneDTO getById(Long id) {
        VteFactureLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteFactureLigneDTO> query(VteFactureLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteFactureLigneDTO toDTO(VteFactureLigne original) {
        VteFactureLigneDTO bean = new VteFactureLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteFactureLigne requireOne(Long id) {
        return vteFactureLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
