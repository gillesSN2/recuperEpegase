package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Services;
import com.yewi.yewicore.recuperation.dtos.ServicesDTO;
import com.yewi.yewicore.recuperation.repository.ServicesRepository;
import com.yewi.yewicore.recuperation.vo.ServicesQueryVO;
import com.yewi.yewicore.recuperation.vo.ServicesUpdateVO;
import com.yewi.yewicore.recuperation.vo.ServicesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    public Long save(ServicesVO vO) {
        Services bean = new Services();
        BeanUtils.copyProperties(vO, bean);
        bean = servicesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        servicesRepository.deleteById(id);
    }

    public void update(Long id, ServicesUpdateVO vO) {
        Services bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        servicesRepository.save(bean);
    }

    public ServicesDTO getById(Long id) {
        Services original = requireOne(id);
        return toDTO(original);
    }

    public Page<ServicesDTO> query(ServicesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ServicesDTO toDTO(Services original) {
        ServicesDTO bean = new ServicesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Services requireOne(Long id) {
        return servicesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
