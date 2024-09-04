package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedLaboratoireResultat;
import com.yewi.yewicore.recuperation.dtos.MedLaboratoireResultatDTO;
import com.yewi.yewicore.recuperation.repository.MedLaboratoireResultatRepository;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireResultatQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireResultatUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireResultatVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedLaboratoireResultatService {

    @Autowired
    private MedLaboratoireResultatRepository medLaboratoireResultatRepository;

    public Long save(MedLaboratoireResultatVO vO) {
        MedLaboratoireResultat bean = new MedLaboratoireResultat();
        BeanUtils.copyProperties(vO, bean);
        bean = medLaboratoireResultatRepository.save(bean);
        return bean.getLabresId();
    }

    public void delete(Long id) {
        medLaboratoireResultatRepository.deleteById(id);
    }

    public void update(Long id, MedLaboratoireResultatUpdateVO vO) {
        MedLaboratoireResultat bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medLaboratoireResultatRepository.save(bean);
    }

    public MedLaboratoireResultatDTO getById(Long id) {
        MedLaboratoireResultat original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedLaboratoireResultatDTO> query(MedLaboratoireResultatQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedLaboratoireResultatDTO toDTO(MedLaboratoireResultat original) {
        MedLaboratoireResultatDTO bean = new MedLaboratoireResultatDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedLaboratoireResultat requireOne(Long id) {
        return medLaboratoireResultatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
