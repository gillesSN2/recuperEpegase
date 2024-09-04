package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesPretsLignesDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesPretsLignesService;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsLignesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsLignesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsLignesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesPretsLignes")
public class PaySalariesPretsLignesController {

    @Autowired
    private PaySalariesPretsLignesService paySalariesPretsLignesService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesPretsLignesVO vO) {
        return paySalariesPretsLignesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesPretsLignesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesPretsLignesUpdateVO vO) {
        paySalariesPretsLignesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesPretsLignesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesPretsLignesService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesPretsLignesDTO> query(@Valid PaySalariesPretsLignesQueryVO vO) {
        return paySalariesPretsLignesService.query(vO);
    }
}
