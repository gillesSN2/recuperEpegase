package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedFamillesProduitsMedical;
import com.yewi.yewicore.recuperation.dtos.MedFamillesProduitsMedicalDTO;
import com.yewi.yewicore.recuperation.repository.MedFamillesProduitsMedicalRepository;
import com.yewi.yewicore.recuperation.vo.MedFamillesProduitsMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedFamillesProduitsMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedFamillesProduitsMedicalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedFamillesProduitsMedicalService {

    @Autowired
    private MedFamillesProduitsMedicalRepository medFamillesProduitsMedicalRepository;

    public Long save(MedFamillesProduitsMedicalVO vO) {
        MedFamillesProduitsMedical bean = new MedFamillesProduitsMedical();
        BeanUtils.copyProperties(vO, bean);
        bean = medFamillesProduitsMedicalRepository.save(bean);
        return bean.getFammedId();
    }

    public void delete(Long id) {
        medFamillesProduitsMedicalRepository.deleteById(id);
    }

    public void update(Long id, MedFamillesProduitsMedicalUpdateVO vO) {
        MedFamillesProduitsMedical bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medFamillesProduitsMedicalRepository.save(bean);
    }

    public MedFamillesProduitsMedicalDTO getById(Long id) {
        MedFamillesProduitsMedical original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedFamillesProduitsMedicalDTO> query(MedFamillesProduitsMedicalQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedFamillesProduitsMedicalDTO toDTO(MedFamillesProduitsMedical original) {
        MedFamillesProduitsMedicalDTO bean = new MedFamillesProduitsMedicalDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedFamillesProduitsMedical requireOne(Long id) {
        return medFamillesProduitsMedicalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
