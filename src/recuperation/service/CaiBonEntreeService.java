package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiBonEntree;
import com.yewi.yewicore.recuperation.dtos.CaiBonEntreeDTO;
import com.yewi.yewicore.recuperation.repository.CaiBonEntreeRepository;
import com.yewi.yewicore.recuperation.vo.CaiBonEntreeQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiBonEntreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiBonEntreeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiBonEntreeService {

    @Autowired
    private CaiBonEntreeRepository caiBonEntreeRepository;

    public Long save(CaiBonEntreeVO vO) {
        CaiBonEntree bean = new CaiBonEntree();
        BeanUtils.copyProperties(vO, bean);
        bean = caiBonEntreeRepository.save(bean);
        return bean.getEntrId();
    }

    public void delete(Long id) {
        caiBonEntreeRepository.deleteById(id);
    }

    public void update(Long id, CaiBonEntreeUpdateVO vO) {
        CaiBonEntree bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiBonEntreeRepository.save(bean);
    }

    public CaiBonEntreeDTO getById(Long id) {
        CaiBonEntree original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiBonEntreeDTO> query(CaiBonEntreeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiBonEntreeDTO toDTO(CaiBonEntree original) {
        CaiBonEntreeDTO bean = new CaiBonEntreeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiBonEntree requireOne(Long id) {
        return caiBonEntreeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
