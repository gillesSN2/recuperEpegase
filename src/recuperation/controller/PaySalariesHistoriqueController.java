package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesHistoriqueDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesHistoriqueService;
import com.yewi.yewicore.recuperation.vo.PaySalariesHistoriqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesHistoriqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesHistoriqueVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesHistorique")
public class PaySalariesHistoriqueController {

    @Autowired
    private PaySalariesHistoriqueService paySalariesHistoriqueService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesHistoriqueVO vO) {
        return paySalariesHistoriqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesHistoriqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesHistoriqueUpdateVO vO) {
        paySalariesHistoriqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesHistoriqueDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesHistoriqueService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesHistoriqueDTO> query(@Valid PaySalariesHistoriqueQueryVO vO) {
        return paySalariesHistoriqueService.query(vO);
    }
}
