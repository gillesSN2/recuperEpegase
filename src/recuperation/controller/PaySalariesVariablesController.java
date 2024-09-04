package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesVariablesDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesVariablesService;
import com.yewi.yewicore.recuperation.vo.PaySalariesVariablesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesVariablesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesVariablesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesVariables")
public class PaySalariesVariablesController {

    @Autowired
    private PaySalariesVariablesService paySalariesVariablesService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesVariablesVO vO) {
        return paySalariesVariablesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesVariablesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesVariablesUpdateVO vO) {
        paySalariesVariablesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesVariablesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesVariablesService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesVariablesDTO> query(@Valid PaySalariesVariablesQueryVO vO) {
        return paySalariesVariablesService.query(vO);
    }
}
