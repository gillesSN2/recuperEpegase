package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayBulletinLigne;
import com.yewi.yewicore.recuperation.dtos.PayBulletinLigneDTO;
import com.yewi.yewicore.recuperation.repository.PayBulletinLigneRepository;
import com.yewi.yewicore.recuperation.vo.PayBulletinLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayBulletinLigneService {

    @Autowired
    private PayBulletinLigneRepository payBulletinLigneRepository;

    public Long save(PayBulletinLigneVO vO) {
        PayBulletinLigne bean = new PayBulletinLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = payBulletinLigneRepository.save(bean);
        return bean.getBulligId();
    }

    public void delete(Long id) {
        payBulletinLigneRepository.deleteById(id);
    }

    public void update(Long id, PayBulletinLigneUpdateVO vO) {
        PayBulletinLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payBulletinLigneRepository.save(bean);
    }

    public PayBulletinLigneDTO getById(Long id) {
        PayBulletinLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayBulletinLigneDTO> query(PayBulletinLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayBulletinLigneDTO toDTO(PayBulletinLigne original) {
        PayBulletinLigneDTO bean = new PayBulletinLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayBulletinLigne requireOne(Long id) {
        return payBulletinLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
