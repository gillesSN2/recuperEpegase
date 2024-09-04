package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesService;
import com.yewi.yewicore.recuperation.vo.PaySalariesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalaries")
public class PaySalariesController {

    @Autowired
    private PaySalariesService paySalariesService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesVO vO) {
        return paySalariesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesUpdateVO vO) {
        paySalariesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesDTO> query(@Valid PaySalariesQueryVO vO) {
        return paySalariesService.query(vO);
    }
}
