package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiBonSortie;
import com.yewi.yewicore.recuperation.dtos.CaiBonSortieDTO;
import com.yewi.yewicore.recuperation.repository.CaiBonSortieRepository;
import com.yewi.yewicore.recuperation.vo.CaiBonSortieQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiBonSortieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiBonSortieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiBonSortieService {

    @Autowired
    private CaiBonSortieRepository caiBonSortieRepository;

    public Long save(CaiBonSortieVO vO) {
        CaiBonSortie bean = new CaiBonSortie();
        BeanUtils.copyProperties(vO, bean);
        bean = caiBonSortieRepository.save(bean);
        return bean.getSortId();
    }

    public void delete(Long id) {
        caiBonSortieRepository.deleteById(id);
    }

    public void update(Long id, CaiBonSortieUpdateVO vO) {
        CaiBonSortie bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiBonSortieRepository.save(bean);
    }

    public CaiBonSortieDTO getById(Long id) {
        CaiBonSortie original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiBonSortieDTO> query(CaiBonSortieQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiBonSortieDTO toDTO(CaiBonSortie original) {
        CaiBonSortieDTO bean = new CaiBonSortieDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiBonSortie requireOne(Long id) {
        return caiBonSortieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
