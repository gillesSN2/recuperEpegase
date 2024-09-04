package recuperation.service;

import com.yewi.yewicore.recuperation.domain.EventPublication;
import com.yewi.yewicore.recuperation.dtos.EventPublicationDTO;
import com.yewi.yewicore.recuperation.repository.EventPublicationRepository;
import com.yewi.yewicore.recuperation.vo.EventPublicationQueryVO;
import com.yewi.yewicore.recuperation.vo.EventPublicationUpdateVO;
import com.yewi.yewicore.recuperation.vo.EventPublicationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EventPublicationService {

    @Autowired
    private EventPublicationRepository eventPublicationRepository;

    public String save(EventPublicationVO vO) {
        EventPublication bean = new EventPublication();
        BeanUtils.copyProperties(vO, bean);
        bean = eventPublicationRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        eventPublicationRepository.deleteById(id);
    }

    public void update(String id, EventPublicationUpdateVO vO) {
        EventPublication bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        eventPublicationRepository.save(bean);
    }

    public EventPublicationDTO getById(String id) {
        EventPublication original = requireOne(id);
        return toDTO(original);
    }

    public Page<EventPublicationDTO> query(EventPublicationQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private EventPublicationDTO toDTO(EventPublication original) {
        EventPublicationDTO bean = new EventPublicationDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private EventPublication requireOne(String id) {
        return eventPublicationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
