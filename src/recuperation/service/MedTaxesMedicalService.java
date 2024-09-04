package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedTaxesMedical;
import com.yewi.yewicore.recuperation.dtos.MedTaxesMedicalDTO;
import com.yewi.yewicore.recuperation.repository.MedTaxesMedicalRepository;
import com.yewi.yewicore.recuperation.vo.MedTaxesMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedTaxesMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedTaxesMedicalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedTaxesMedicalService {

    @Autowired
    private MedTaxesMedicalRepository medTaxesMedicalRepository;

    public Long save(MedTaxesMedicalVO vO) {
        MedTaxesMedical bean = new MedTaxesMedical();
        BeanUtils.copyProperties(vO, bean);
        bean = medTaxesMedicalRepository.save(bean);
        return bean.getTaxmedId();
    }

    public void delete(Long id) {
        medTaxesMedicalRepository.deleteById(id);
    }

    public void update(Long id, MedTaxesMedicalUpdateVO vO) {
        MedTaxesMedical bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medTaxesMedicalRepository.save(bean);
    }

    public MedTaxesMedicalDTO getById(Long id) {
        MedTaxesMedical original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedTaxesMedicalDTO> query(MedTaxesMedicalQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedTaxesMedicalDTO toDTO(MedTaxesMedical original) {
        MedTaxesMedicalDTO bean = new MedTaxesMedicalDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedTaxesMedical requireOne(Long id) {
        return medTaxesMedicalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
