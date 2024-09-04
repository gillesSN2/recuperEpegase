package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Secteurs;
import com.yewi.yewicore.recuperation.dtos.SecteursDTO;
import com.yewi.yewicore.recuperation.repository.SecteursRepository;
import com.yewi.yewicore.recuperation.vo.SecteursQueryVO;
import com.yewi.yewicore.recuperation.vo.SecteursUpdateVO;
import com.yewi.yewicore.recuperation.vo.SecteursVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SecteursService {

    @Autowired
    private SecteursRepository secteursRepository;

    public Long save(SecteursVO vO) {
        Secteurs bean = new Secteurs();
        BeanUtils.copyProperties(vO, bean);
        bean = secteursRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        secteursRepository.deleteById(id);
    }

    public void update(Long id, SecteursUpdateVO vO) {
        Secteurs bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        secteursRepository.save(bean);
    }

    public SecteursDTO getById(Long id) {
        Secteurs original = requireOne(id);
        return toDTO(original);
    }

    public Page<SecteursDTO> query(SecteursQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SecteursDTO toDTO(Secteurs original) {
        SecteursDTO bean = new SecteursDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Secteurs requireOne(Long id) {
        return secteursRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
