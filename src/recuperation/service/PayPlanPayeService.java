package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayPlanPaye;
import com.yewi.yewicore.recuperation.dtos.PayPlanPayeDTO;
import com.yewi.yewicore.recuperation.repository.PayPlanPayeRepository;
import com.yewi.yewicore.recuperation.vo.PayPlanPayeQueryVO;
import com.yewi.yewicore.recuperation.vo.PayPlanPayeUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayPlanPayeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayPlanPayeService {

    @Autowired
    private PayPlanPayeRepository payPlanPayeRepository;

    public Long save(PayPlanPayeVO vO) {
        PayPlanPaye bean = new PayPlanPaye();
        BeanUtils.copyProperties(vO, bean);
        bean = payPlanPayeRepository.save(bean);
        return bean.getPlpId();
    }

    public void delete(Long id) {
        payPlanPayeRepository.deleteById(id);
    }

    public void update(Long id, PayPlanPayeUpdateVO vO) {
        PayPlanPaye bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payPlanPayeRepository.save(bean);
    }

    public PayPlanPayeDTO getById(Long id) {
        PayPlanPaye original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayPlanPayeDTO> query(PayPlanPayeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayPlanPayeDTO toDTO(PayPlanPaye original) {
        PayPlanPayeDTO bean = new PayPlanPayeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayPlanPaye requireOne(Long id) {
        return payPlanPayeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
