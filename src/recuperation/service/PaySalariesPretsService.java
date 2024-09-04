package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesPrets;
import com.yewi.yewicore.recuperation.dtos.PaySalariesPretsDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesPretsRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesPretsService {

    @Autowired
    private PaySalariesPretsRepository paySalariesPretsRepository;

    public Long save(PaySalariesPretsVO vO) {
        PaySalariesPrets bean = new PaySalariesPrets();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesPretsRepository.save(bean);
        return bean.getSalpreId();
    }

    public void delete(Long id) {
        paySalariesPretsRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesPretsUpdateVO vO) {
        PaySalariesPrets bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesPretsRepository.save(bean);
    }

    public PaySalariesPretsDTO getById(Long id) {
        PaySalariesPrets original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesPretsDTO> query(PaySalariesPretsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesPretsDTO toDTO(PaySalariesPrets original) {
        PaySalariesPretsDTO bean = new PaySalariesPretsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesPrets requireOne(Long id) {
        return paySalariesPretsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
