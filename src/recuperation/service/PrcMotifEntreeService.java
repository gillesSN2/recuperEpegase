package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PrcMotifEntree;
import com.yewi.yewicore.recuperation.dtos.PrcMotifEntreeDTO;
import com.yewi.yewicore.recuperation.repository.PrcMotifEntreeRepository;
import com.yewi.yewicore.recuperation.vo.PrcMotifEntreeQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcMotifEntreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcMotifEntreeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrcMotifEntreeService {

    @Autowired
    private PrcMotifEntreeRepository prcMotifEntreeRepository;

    public Long save(PrcMotifEntreeVO vO) {
        PrcMotifEntree bean = new PrcMotifEntree();
        BeanUtils.copyProperties(vO, bean);
        bean = prcMotifEntreeRepository.save(bean);
        return bean.getMtpId();
    }

    public void delete(Long id) {
        prcMotifEntreeRepository.deleteById(id);
    }

    public void update(Long id, PrcMotifEntreeUpdateVO vO) {
        PrcMotifEntree bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        prcMotifEntreeRepository.save(bean);
    }

    public PrcMotifEntreeDTO getById(Long id) {
        PrcMotifEntree original = requireOne(id);
        return toDTO(original);
    }

    public Page<PrcMotifEntreeDTO> query(PrcMotifEntreeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PrcMotifEntreeDTO toDTO(PrcMotifEntree original) {
        PrcMotifEntreeDTO bean = new PrcMotifEntreeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PrcMotifEntree requireOne(Long id) {
        return prcMotifEntreeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
