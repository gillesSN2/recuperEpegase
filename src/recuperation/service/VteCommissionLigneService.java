package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteCommissionLigne;
import com.yewi.yewicore.recuperation.dtos.VteCommissionLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteCommissionLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteCommissionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteCommissionLigneService {

    @Autowired
    private VteCommissionLigneRepository vteCommissionLigneRepository;

    public Long save(VteCommissionLigneVO vO) {
        VteCommissionLigne bean = new VteCommissionLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteCommissionLigneRepository.save(bean);
        return bean.getComligId();
    }

    public void delete(Long id) {
        vteCommissionLigneRepository.deleteById(id);
    }

    public void update(Long id, VteCommissionLigneUpdateVO vO) {
        VteCommissionLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteCommissionLigneRepository.save(bean);
    }

    public VteCommissionLigneDTO getById(Long id) {
        VteCommissionLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteCommissionLigneDTO> query(VteCommissionLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteCommissionLigneDTO toDTO(VteCommissionLigne original) {
        VteCommissionLigneDTO bean = new VteCommissionLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteCommissionLigne requireOne(Long id) {
        return vteCommissionLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
