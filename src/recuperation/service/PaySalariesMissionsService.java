package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesMissions;
import com.yewi.yewicore.recuperation.dtos.PaySalariesMissionsDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesMissionsRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesMissionsService {

    @Autowired
    private PaySalariesMissionsRepository paySalariesMissionsRepository;

    public Long save(PaySalariesMissionsVO vO) {
        PaySalariesMissions bean = new PaySalariesMissions();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesMissionsRepository.save(bean);
        return bean.getSalmisId();
    }

    public void delete(Long id) {
        paySalariesMissionsRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesMissionsUpdateVO vO) {
        PaySalariesMissions bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesMissionsRepository.save(bean);
    }

    public PaySalariesMissionsDTO getById(Long id) {
        PaySalariesMissions original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesMissionsDTO> query(PaySalariesMissionsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesMissionsDTO toDTO(PaySalariesMissions original) {
        PaySalariesMissionsDTO bean = new PaySalariesMissionsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesMissions requireOne(Long id) {
        return paySalariesMissionsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
