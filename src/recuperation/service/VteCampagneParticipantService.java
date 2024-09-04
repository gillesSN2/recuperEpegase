package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteCampagneParticipant;
import com.yewi.yewicore.recuperation.dtos.VteCampagneParticipantDTO;
import com.yewi.yewicore.recuperation.repository.VteCampagneParticipantRepository;
import com.yewi.yewicore.recuperation.vo.VteCampagneParticipantQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneParticipantUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneParticipantVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteCampagneParticipantService {

    @Autowired
    private VteCampagneParticipantRepository vteCampagneParticipantRepository;

    public Long save(VteCampagneParticipantVO vO) {
        VteCampagneParticipant bean = new VteCampagneParticipant();
        BeanUtils.copyProperties(vO, bean);
        bean = vteCampagneParticipantRepository.save(bean);
        return bean.getCamparId();
    }

    public void delete(Long id) {
        vteCampagneParticipantRepository.deleteById(id);
    }

    public void update(Long id, VteCampagneParticipantUpdateVO vO) {
        VteCampagneParticipant bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteCampagneParticipantRepository.save(bean);
    }

    public VteCampagneParticipantDTO getById(Long id) {
        VteCampagneParticipant original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteCampagneParticipantDTO> query(VteCampagneParticipantQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteCampagneParticipantDTO toDTO(VteCampagneParticipant original) {
        VteCampagneParticipantDTO bean = new VteCampagneParticipantDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteCampagneParticipant requireOne(Long id) {
        return vteCampagneParticipantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
