package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchInventaireLigne;
import com.yewi.yewicore.recuperation.dtos.AchInventaireLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchInventaireLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchInventaireLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchInventaireLigneService {

    @Autowired
    private AchInventaireLigneRepository achInventaireLigneRepository;

    public Long save(AchInventaireLigneVO vO) {
        AchInventaireLigne bean = new AchInventaireLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achInventaireLigneRepository.save(bean);
        return bean.getInvligId();
    }

    public void delete(Long id) {
        achInventaireLigneRepository.deleteById(id);
    }

    public void update(Long id, AchInventaireLigneUpdateVO vO) {
        AchInventaireLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achInventaireLigneRepository.save(bean);
    }

    public AchInventaireLigneDTO getById(Long id) {
        AchInventaireLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchInventaireLigneDTO> query(AchInventaireLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchInventaireLigneDTO toDTO(AchInventaireLigne original) {
        AchInventaireLigneDTO bean = new AchInventaireLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchInventaireLigne requireOne(Long id) {
        return achInventaireLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
