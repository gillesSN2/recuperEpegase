package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPathologie;
import com.yewi.yewicore.recuperation.dtos.MedPathologieDTO;
import com.yewi.yewicore.recuperation.repository.MedPathologieRepository;
import com.yewi.yewicore.recuperation.vo.MedPathologieQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPathologieUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPathologieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPathologieService {

    @Autowired
    private MedPathologieRepository medPathologieRepository;

    public Long save(MedPathologieVO vO) {
        MedPathologie bean = new MedPathologie();
        BeanUtils.copyProperties(vO, bean);
        bean = medPathologieRepository.save(bean);
        return bean.getPhlId();
    }

    public void delete(Long id) {
        medPathologieRepository.deleteById(id);
    }

    public void update(Long id, MedPathologieUpdateVO vO) {
        MedPathologie bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPathologieRepository.save(bean);
    }

    public MedPathologieDTO getById(Long id) {
        MedPathologie original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPathologieDTO> query(MedPathologieQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPathologieDTO toDTO(MedPathologie original) {
        MedPathologieDTO bean = new MedPathologieDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPathologie requireOne(Long id) {
        return medPathologieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
