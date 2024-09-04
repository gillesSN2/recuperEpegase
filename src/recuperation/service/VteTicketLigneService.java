package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteTicketLigne;
import com.yewi.yewicore.recuperation.dtos.VteTicketLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteTicketLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteTicketLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteTicketLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteTicketLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteTicketLigneService {

    @Autowired
    private VteTicketLigneRepository vteTicketLigneRepository;

    public Long save(VteTicketLigneVO vO) {
        VteTicketLigne bean = new VteTicketLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteTicketLigneRepository.save(bean);
        return bean.getTicligId();
    }

    public void delete(Long id) {
        vteTicketLigneRepository.deleteById(id);
    }

    public void update(Long id, VteTicketLigneUpdateVO vO) {
        VteTicketLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteTicketLigneRepository.save(bean);
    }

    public VteTicketLigneDTO getById(Long id) {
        VteTicketLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteTicketLigneDTO> query(VteTicketLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteTicketLigneDTO toDTO(VteTicketLigne original) {
        VteTicketLigneDTO bean = new VteTicketLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteTicketLigne requireOne(Long id) {
        return vteTicketLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
