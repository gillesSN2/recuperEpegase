package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayFeuilleCalcul;
import com.yewi.yewicore.recuperation.dtos.PayFeuilleCalculDTO;
import com.yewi.yewicore.recuperation.repository.PayFeuilleCalculRepository;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculQueryVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayFeuilleCalculService {

    @Autowired
    private PayFeuilleCalculRepository payFeuilleCalculRepository;

    public Long save(PayFeuilleCalculVO vO) {
        PayFeuilleCalcul bean = new PayFeuilleCalcul();
        BeanUtils.copyProperties(vO, bean);
        bean = payFeuilleCalculRepository.save(bean);
        return bean.getFeuId();
    }

    public void delete(Long id) {
        payFeuilleCalculRepository.deleteById(id);
    }

    public void update(Long id, PayFeuilleCalculUpdateVO vO) {
        PayFeuilleCalcul bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payFeuilleCalculRepository.save(bean);
    }

    public PayFeuilleCalculDTO getById(Long id) {
        PayFeuilleCalcul original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayFeuilleCalculDTO> query(PayFeuilleCalculQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayFeuilleCalculDTO toDTO(PayFeuilleCalcul original) {
        PayFeuilleCalculDTO bean = new PayFeuilleCalculDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayFeuilleCalcul requireOne(Long id) {
        return payFeuilleCalculRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
