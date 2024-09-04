package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteBcommandeLigne;
import com.yewi.yewicore.recuperation.dtos.VteBcommandeLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteBcommandeLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteBcommandeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteBcommandeLigneService {

    @Autowired
    private VteBcommandeLigneRepository vteBcommandeLigneRepository;

    public Long save(VteBcommandeLigneVO vO) {
        VteBcommandeLigne bean = new VteBcommandeLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteBcommandeLigneRepository.save(bean);
        return bean.getBcmligId();
    }

    public void delete(Long id) {
        vteBcommandeLigneRepository.deleteById(id);
    }

    public void update(Long id, VteBcommandeLigneUpdateVO vO) {
        VteBcommandeLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteBcommandeLigneRepository.save(bean);
    }

    public VteBcommandeLigneDTO getById(Long id) {
        VteBcommandeLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteBcommandeLigneDTO> query(VteBcommandeLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteBcommandeLigneDTO toDTO(VteBcommandeLigne original) {
        VteBcommandeLigneDTO bean = new VteBcommandeLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteBcommandeLigne requireOne(Long id) {
        return vteBcommandeLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
