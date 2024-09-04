package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayBulletinSalaire;
import com.yewi.yewicore.recuperation.dtos.PayBulletinSalaireDTO;
import com.yewi.yewicore.recuperation.repository.PayBulletinSalaireRepository;
import com.yewi.yewicore.recuperation.vo.PayBulletinSalaireQueryVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinSalaireUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinSalaireVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayBulletinSalaireService {

    @Autowired
    private PayBulletinSalaireRepository payBulletinSalaireRepository;

    public Long save(PayBulletinSalaireVO vO) {
        PayBulletinSalaire bean = new PayBulletinSalaire();
        BeanUtils.copyProperties(vO, bean);
        bean = payBulletinSalaireRepository.save(bean);
        return bean.getBulsalId();
    }

    public void delete(Long id) {
        payBulletinSalaireRepository.deleteById(id);
    }

    public void update(Long id, PayBulletinSalaireUpdateVO vO) {
        PayBulletinSalaire bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payBulletinSalaireRepository.save(bean);
    }

    public PayBulletinSalaireDTO getById(Long id) {
        PayBulletinSalaire original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayBulletinSalaireDTO> query(PayBulletinSalaireQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayBulletinSalaireDTO toDTO(PayBulletinSalaire original) {
        PayBulletinSalaireDTO bean = new PayBulletinSalaireDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayBulletinSalaire requireOne(Long id) {
        return payBulletinSalaireRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
