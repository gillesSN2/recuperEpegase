package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteTicketEntete;
import com.yewi.yewicore.recuperation.dtos.VteTicketEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteTicketEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteTicketEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteTicketEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteTicketEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteTicketEnteteService {

    @Autowired
    private VteTicketEnteteRepository vteTicketEnteteRepository;

    public Long save(VteTicketEnteteVO vO) {
        VteTicketEntete bean = new VteTicketEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteTicketEnteteRepository.save(bean);
        return bean.getTicId();
    }

    public void delete(Long id) {
        vteTicketEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteTicketEnteteUpdateVO vO) {
        VteTicketEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteTicketEnteteRepository.save(bean);
    }

    public VteTicketEnteteDTO getById(Long id) {
        VteTicketEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteTicketEnteteDTO> query(VteTicketEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteTicketEnteteDTO toDTO(VteTicketEntete original) {
        VteTicketEnteteDTO bean = new VteTicketEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteTicketEntete requireOne(Long id) {
        return vteTicketEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
