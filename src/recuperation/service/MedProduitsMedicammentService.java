package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedProduitsMedicamment;
import com.yewi.yewicore.recuperation.dtos.MedProduitsMedicammentDTO;
import com.yewi.yewicore.recuperation.repository.MedProduitsMedicammentRepository;
import com.yewi.yewicore.recuperation.vo.MedProduitsMedicammentQueryVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsMedicammentUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsMedicammentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedProduitsMedicammentService {

    @Autowired
    private MedProduitsMedicammentRepository medProduitsMedicammentRepository;

    public Long save(MedProduitsMedicammentVO vO) {
        MedProduitsMedicamment bean = new MedProduitsMedicamment();
        BeanUtils.copyProperties(vO, bean);
        bean = medProduitsMedicammentRepository.save(bean);
        return bean.getPromdcId();
    }

    public void delete(Long id) {
        medProduitsMedicammentRepository.deleteById(id);
    }

    public void update(Long id, MedProduitsMedicammentUpdateVO vO) {
        MedProduitsMedicamment bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medProduitsMedicammentRepository.save(bean);
    }

    public MedProduitsMedicammentDTO getById(Long id) {
        MedProduitsMedicamment original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedProduitsMedicammentDTO> query(MedProduitsMedicammentQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedProduitsMedicammentDTO toDTO(MedProduitsMedicamment original) {
        MedProduitsMedicammentDTO bean = new MedProduitsMedicammentDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedProduitsMedicamment requireOne(Long id) {
        return medProduitsMedicammentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
