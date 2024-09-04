package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesMissionsFrais;
import com.yewi.yewicore.recuperation.dtos.PaySalariesMissionsFraisDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesMissionsFraisRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsFraisQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsFraisUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsFraisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesMissionsFraisService {

    @Autowired
    private PaySalariesMissionsFraisRepository paySalariesMissionsFraisRepository;

    public Long save(PaySalariesMissionsFraisVO vO) {
        PaySalariesMissionsFrais bean = new PaySalariesMissionsFrais();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesMissionsFraisRepository.save(bean);
        return bean.getSalmisfraId();
    }

    public void delete(Long id) {
        paySalariesMissionsFraisRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesMissionsFraisUpdateVO vO) {
        PaySalariesMissionsFrais bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesMissionsFraisRepository.save(bean);
    }

    public PaySalariesMissionsFraisDTO getById(Long id) {
        PaySalariesMissionsFrais original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesMissionsFraisDTO> query(PaySalariesMissionsFraisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesMissionsFraisDTO toDTO(PaySalariesMissionsFrais original) {
        PaySalariesMissionsFraisDTO bean = new PaySalariesMissionsFraisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesMissionsFrais requireOne(Long id) {
        return paySalariesMissionsFraisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
