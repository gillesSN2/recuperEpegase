package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayMissions;
import com.yewi.yewicore.recuperation.dtos.PayMissionsDTO;
import com.yewi.yewicore.recuperation.repository.PayMissionsRepository;
import com.yewi.yewicore.recuperation.vo.PayMissionsQueryVO;
import com.yewi.yewicore.recuperation.vo.PayMissionsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayMissionsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayMissionsService {

    @Autowired
    private PayMissionsRepository payMissionsRepository;

    public Long save(PayMissionsVO vO) {
        PayMissions bean = new PayMissions();
        BeanUtils.copyProperties(vO, bean);
        bean = payMissionsRepository.save(bean);
        return bean.getMisId();
    }

    public void delete(Long id) {
        payMissionsRepository.deleteById(id);
    }

    public void update(Long id, PayMissionsUpdateVO vO) {
        PayMissions bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payMissionsRepository.save(bean);
    }

    public PayMissionsDTO getById(Long id) {
        PayMissions original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayMissionsDTO> query(PayMissionsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayMissionsDTO toDTO(PayMissions original) {
        PayMissionsDTO bean = new PayMissionsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayMissions requireOne(Long id) {
        return payMissionsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
