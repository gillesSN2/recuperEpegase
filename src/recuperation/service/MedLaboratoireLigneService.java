package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedLaboratoireLigne;
import com.yewi.yewicore.recuperation.dtos.MedLaboratoireLigneDTO;
import com.yewi.yewicore.recuperation.repository.MedLaboratoireLigneRepository;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedLaboratoireLigneService {

    @Autowired
    private MedLaboratoireLigneRepository medLaboratoireLigneRepository;

    public Long save(MedLaboratoireLigneVO vO) {
        MedLaboratoireLigne bean = new MedLaboratoireLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = medLaboratoireLigneRepository.save(bean);
        return bean.getLabligId();
    }

    public void delete(Long id) {
        medLaboratoireLigneRepository.deleteById(id);
    }

    public void update(Long id, MedLaboratoireLigneUpdateVO vO) {
        MedLaboratoireLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medLaboratoireLigneRepository.save(bean);
    }

    public MedLaboratoireLigneDTO getById(Long id) {
        MedLaboratoireLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedLaboratoireLigneDTO> query(MedLaboratoireLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedLaboratoireLigneDTO toDTO(MedLaboratoireLigne original) {
        MedLaboratoireLigneDTO bean = new MedLaboratoireLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedLaboratoireLigne requireOne(Long id) {
        return medLaboratoireLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
