package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesCapitalisation;
import com.yewi.yewicore.recuperation.dtos.PaySalariesCapitalisationDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesCapitalisationRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesCapitalisationQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCapitalisationUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCapitalisationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesCapitalisationService {

    @Autowired
    private PaySalariesCapitalisationRepository paySalariesCapitalisationRepository;

    public Long save(PaySalariesCapitalisationVO vO) {
        PaySalariesCapitalisation bean = new PaySalariesCapitalisation();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesCapitalisationRepository.save(bean);
        return bean.getSalcapId();
    }

    public void delete(Long id) {
        paySalariesCapitalisationRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesCapitalisationUpdateVO vO) {
        PaySalariesCapitalisation bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesCapitalisationRepository.save(bean);
    }

    public PaySalariesCapitalisationDTO getById(Long id) {
        PaySalariesCapitalisation original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesCapitalisationDTO> query(PaySalariesCapitalisationQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesCapitalisationDTO toDTO(PaySalariesCapitalisation original) {
        PaySalariesCapitalisationDTO bean = new PaySalariesCapitalisationDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesCapitalisation requireOne(Long id) {
        return paySalariesCapitalisationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
