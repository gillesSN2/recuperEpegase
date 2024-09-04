package recuperation.service;

import com.yewi.yewicore.recuperation.domain.Devises;
import com.yewi.yewicore.recuperation.dtos.DevisesDTO;
import com.yewi.yewicore.recuperation.repository.DevisesRepository;
import com.yewi.yewicore.recuperation.vo.DevisesQueryVO;
import com.yewi.yewicore.recuperation.vo.DevisesUpdateVO;
import com.yewi.yewicore.recuperation.vo.DevisesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DevisesService {

    @Autowired
    private DevisesRepository devisesRepository;

    public String save(DevisesVO vO) {
        Devises bean = new Devises();
        BeanUtils.copyProperties(vO, bean);
        bean = devisesRepository.save(bean);
        return bean.getCode();
    }

    public void delete(String id) {
        devisesRepository.deleteById(id);
    }

    public void update(String id, DevisesUpdateVO vO) {
        Devises bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        devisesRepository.save(bean);
    }

    public DevisesDTO getById(String id) {
        Devises original = requireOne(id);
        return toDTO(original);
    }

    public Page<DevisesDTO> query(DevisesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DevisesDTO toDTO(Devises original) {
        DevisesDTO bean = new DevisesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Devises requireOne(String id) {
        return devisesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
