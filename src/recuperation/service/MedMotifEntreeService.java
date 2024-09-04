package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedMotifEntree;
import com.yewi.yewicore.recuperation.dtos.MedMotifEntreeDTO;
import com.yewi.yewicore.recuperation.repository.MedMotifEntreeRepository;
import com.yewi.yewicore.recuperation.vo.MedMotifEntreeQueryVO;
import com.yewi.yewicore.recuperation.vo.MedMotifEntreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedMotifEntreeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedMotifEntreeService {

    @Autowired
    private MedMotifEntreeRepository medMotifEntreeRepository;

    public Long save(MedMotifEntreeVO vO) {
        MedMotifEntree bean = new MedMotifEntree();
        BeanUtils.copyProperties(vO, bean);
        bean = medMotifEntreeRepository.save(bean);
        return bean.getMteId();
    }

    public void delete(Long id) {
        medMotifEntreeRepository.deleteById(id);
    }

    public void update(Long id, MedMotifEntreeUpdateVO vO) {
        MedMotifEntree bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medMotifEntreeRepository.save(bean);
    }

    public MedMotifEntreeDTO getById(Long id) {
        MedMotifEntree original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedMotifEntreeDTO> query(MedMotifEntreeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedMotifEntreeDTO toDTO(MedMotifEntree original) {
        MedMotifEntreeDTO bean = new MedMotifEntreeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedMotifEntree requireOne(Long id) {
        return medMotifEntreeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
