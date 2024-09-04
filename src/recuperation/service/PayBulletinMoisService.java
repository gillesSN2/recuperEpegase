package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PayBulletinMois;
import com.yewi.yewicore.recuperation.dtos.PayBulletinMoisDTO;
import com.yewi.yewicore.recuperation.repository.PayBulletinMoisRepository;
import com.yewi.yewicore.recuperation.vo.PayBulletinMoisQueryVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinMoisUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinMoisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PayBulletinMoisService {

    @Autowired
    private PayBulletinMoisRepository payBulletinMoisRepository;

    public Long save(PayBulletinMoisVO vO) {
        PayBulletinMois bean = new PayBulletinMois();
        BeanUtils.copyProperties(vO, bean);
        bean = payBulletinMoisRepository.save(bean);
        return bean.getBulmenId();
    }

    public void delete(Long id) {
        payBulletinMoisRepository.deleteById(id);
    }

    public void update(Long id, PayBulletinMoisUpdateVO vO) {
        PayBulletinMois bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        payBulletinMoisRepository.save(bean);
    }

    public PayBulletinMoisDTO getById(Long id) {
        PayBulletinMois original = requireOne(id);
        return toDTO(original);
    }

    public Page<PayBulletinMoisDTO> query(PayBulletinMoisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PayBulletinMoisDTO toDTO(PayBulletinMois original) {
        PayBulletinMoisDTO bean = new PayBulletinMoisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PayBulletinMois requireOne(Long id) {
        return payBulletinMoisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
