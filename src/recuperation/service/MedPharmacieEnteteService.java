package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPharmacieEntete;
import com.yewi.yewicore.recuperation.dtos.MedPharmacieEnteteDTO;
import com.yewi.yewicore.recuperation.repository.MedPharmacieEnteteRepository;
import com.yewi.yewicore.recuperation.vo.MedPharmacieEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPharmacieEnteteService {

    @Autowired
    private MedPharmacieEnteteRepository medPharmacieEnteteRepository;

    public Long save(MedPharmacieEnteteVO vO) {
        MedPharmacieEntete bean = new MedPharmacieEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = medPharmacieEnteteRepository.save(bean);
        return bean.getPhaId();
    }

    public void delete(Long id) {
        medPharmacieEnteteRepository.deleteById(id);
    }

    public void update(Long id, MedPharmacieEnteteUpdateVO vO) {
        MedPharmacieEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPharmacieEnteteRepository.save(bean);
    }

    public MedPharmacieEnteteDTO getById(Long id) {
        MedPharmacieEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPharmacieEnteteDTO> query(MedPharmacieEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPharmacieEnteteDTO toDTO(MedPharmacieEntete original) {
        MedPharmacieEnteteDTO bean = new MedPharmacieEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPharmacieEntete requireOne(Long id) {
        return medPharmacieEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
