package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PointDeVentes;
import com.yewi.yewicore.recuperation.dtos.PointDeVentesDTO;
import com.yewi.yewicore.recuperation.repository.PointDeVentesRepository;
import com.yewi.yewicore.recuperation.vo.PointDeVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.PointDeVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PointDeVentesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PointDeVentesService {

    @Autowired
    private PointDeVentesRepository pointDeVentesRepository;

    public Long save(PointDeVentesVO vO) {
        PointDeVentes bean = new PointDeVentes();
        BeanUtils.copyProperties(vO, bean);
        bean = pointDeVentesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        pointDeVentesRepository.deleteById(id);
    }

    public void update(Long id, PointDeVentesUpdateVO vO) {
        PointDeVentes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        pointDeVentesRepository.save(bean);
    }

    public PointDeVentesDTO getById(Long id) {
        PointDeVentes original = requireOne(id);
        return toDTO(original);
    }

    public Page<PointDeVentesDTO> query(PointDeVentesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PointDeVentesDTO toDTO(PointDeVentes original) {
        PointDeVentesDTO bean = new PointDeVentesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PointDeVentes requireOne(Long id) {
        return pointDeVentesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
