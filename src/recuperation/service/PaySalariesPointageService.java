package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesPointage;
import com.yewi.yewicore.recuperation.dtos.PaySalariesPointageDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesPointageRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesPointageQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPointageUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPointageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesPointageService {

    @Autowired
    private PaySalariesPointageRepository paySalariesPointageRepository;

    public Long save(PaySalariesPointageVO vO) {
        PaySalariesPointage bean = new PaySalariesPointage();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesPointageRepository.save(bean);
        return bean.getSalpoiId();
    }

    public void delete(Long id) {
        paySalariesPointageRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesPointageUpdateVO vO) {
        PaySalariesPointage bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesPointageRepository.save(bean);
    }

    public PaySalariesPointageDTO getById(Long id) {
        PaySalariesPointage original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesPointageDTO> query(PaySalariesPointageQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesPointageDTO toDTO(PaySalariesPointage original) {
        PaySalariesPointageDTO bean = new PaySalariesPointageDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesPointage requireOne(Long id) {
        return paySalariesPointageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
