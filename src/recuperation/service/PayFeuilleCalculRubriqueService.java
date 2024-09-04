package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayFeuilleCalculRubrique;
import com.yewi.yewicore.recuperation.dtos.PayFeuilleCalculRubriqueDTO;
import com.yewi.yewicore.recuperation.repository.PayFeuilleCalculRubriqueRepository;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculRubriqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculRubriqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculRubriqueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayFeuilleCalculRubriqueService {

    @Autowired
    private PayFeuilleCalculRubriqueRepository payFeuilleCalculRubriqueRepository;

    public Long save(PayFeuilleCalculRubriqueVO vO) {
        PayFeuilleCalculRubrique bean = new PayFeuilleCalculRubrique();
        BeanUtils.copyProperties(vO, bean);
        bean = payFeuilleCalculRubriqueRepository.save(bean);
        return bean.getFeurubId();
    }

    public void delete(Long id) {
        payFeuilleCalculRubriqueRepository.deleteById(id);
    }

    public void update(Long id, PayFeuilleCalculRubriqueUpdateVO vO) {
        PayFeuilleCalculRubrique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payFeuilleCalculRubriqueRepository.save(bean);
    }

    public PayFeuilleCalculRubriqueDTO getById(Long id) {
        PayFeuilleCalculRubrique original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayFeuilleCalculRubriqueDTO> query(PayFeuilleCalculRubriqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayFeuilleCalculRubriqueDTO toDTO(PayFeuilleCalculRubrique original) {
        PayFeuilleCalculRubriqueDTO bean = new PayFeuilleCalculRubriqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayFeuilleCalculRubrique requireOne(Long id) {
        return payFeuilleCalculRubriqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
