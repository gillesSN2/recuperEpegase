package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayExercicesPaye;
import com.yewi.yewicore.recuperation.dtos.PayExercicesPayeDTO;
import com.yewi.yewicore.recuperation.repository.PayExercicesPayeRepository;
import com.yewi.yewicore.recuperation.vo.PayExercicesPayeQueryVO;
import com.yewi.yewicore.recuperation.vo.PayExercicesPayeUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayExercicesPayeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayExercicesPayeService {

    @Autowired
    private PayExercicesPayeRepository payExercicesPayeRepository;

    public Long save(PayExercicesPayeVO vO) {
        PayExercicesPaye bean = new PayExercicesPaye();
        BeanUtils.copyProperties(vO, bean);
        bean = payExercicesPayeRepository.save(bean);
        return bean.getExepayId();
    }

    public void delete(Long id) {
        payExercicesPayeRepository.deleteById(id);
    }

    public void update(Long id, PayExercicesPayeUpdateVO vO) {
        PayExercicesPaye bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payExercicesPayeRepository.save(bean);
    }

    public PayExercicesPayeDTO getById(Long id) {
        PayExercicesPaye original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayExercicesPayeDTO> query(PayExercicesPayeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayExercicesPayeDTO toDTO(PayExercicesPaye original) {
        PayExercicesPayeDTO bean = new PayExercicesPayeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayExercicesPaye requireOne(Long id) {
        return payExercicesPayeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
