package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayFeuilleCalculFormule;
import com.yewi.yewicore.recuperation.dtos.PayFeuilleCalculFormuleDTO;
import com.yewi.yewicore.recuperation.repository.PayFeuilleCalculFormuleRepository;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculFormuleQueryVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculFormuleUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculFormuleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayFeuilleCalculFormuleService {

    @Autowired
    private PayFeuilleCalculFormuleRepository payFeuilleCalculFormuleRepository;

    public Long save(PayFeuilleCalculFormuleVO vO) {
        PayFeuilleCalculFormule bean = new PayFeuilleCalculFormule();
        BeanUtils.copyProperties(vO, bean);
        bean = payFeuilleCalculFormuleRepository.save(bean);
        return bean.getFeurubforId();
    }

    public void delete(Long id) {
        payFeuilleCalculFormuleRepository.deleteById(id);
    }

    public void update(Long id, PayFeuilleCalculFormuleUpdateVO vO) {
        PayFeuilleCalculFormule bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payFeuilleCalculFormuleRepository.save(bean);
    }

    public PayFeuilleCalculFormuleDTO getById(Long id) {
        PayFeuilleCalculFormule original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayFeuilleCalculFormuleDTO> query(PayFeuilleCalculFormuleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayFeuilleCalculFormuleDTO toDTO(PayFeuilleCalculFormule original) {
        PayFeuilleCalculFormuleDTO bean = new PayFeuilleCalculFormuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayFeuilleCalculFormule requireOne(Long id) {
        return payFeuilleCalculFormuleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
