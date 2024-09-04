package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedProduitsDci;
import com.yewi.yewicore.recuperation.dtos.MedProduitsDciDTO;
import com.yewi.yewicore.recuperation.repository.MedProduitsDciRepository;
import com.yewi.yewicore.recuperation.vo.MedProduitsDciQueryVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsDciUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsDciVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedProduitsDciService {

    @Autowired
    private MedProduitsDciRepository medProduitsDciRepository;

    public Long save(MedProduitsDciVO vO) {
        MedProduitsDci bean = new MedProduitsDci();
        BeanUtils.copyProperties(vO, bean);
        bean = medProduitsDciRepository.save(bean);
        return bean.getProdciId();
    }

    public void delete(Long id) {
        medProduitsDciRepository.deleteById(id);
    }

    public void update(Long id, MedProduitsDciUpdateVO vO) {
        MedProduitsDci bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medProduitsDciRepository.save(bean);
    }

    public MedProduitsDciDTO getById(Long id) {
        MedProduitsDci original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedProduitsDciDTO> query(MedProduitsDciQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedProduitsDciDTO toDTO(MedProduitsDci original) {
        MedProduitsDciDTO bean = new MedProduitsDciDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedProduitsDci requireOne(Long id) {
        return medProduitsDciRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
