package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayPlanPayeDTO;
import com.yewi.yewicore.recuperation.service.PayPlanPayeService;
import com.yewi.yewicore.recuperation.vo.PayPlanPayeQueryVO;
import com.yewi.yewicore.recuperation.vo.PayPlanPayeUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayPlanPayeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payPlanPaye")
public class PayPlanPayeController {

    @Autowired
    private PayPlanPayeService payPlanPayeService;

    @PostMapping
    public String save(@Valid @RequestBody PayPlanPayeVO vO) {
        return payPlanPayeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payPlanPayeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayPlanPayeUpdateVO vO) {
        payPlanPayeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayPlanPayeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payPlanPayeService.getById(id);
    }

    @GetMapping
    public Page<PayPlanPayeDTO> query(@Valid PayPlanPayeQueryVO vO) {
        return payPlanPayeService.query(vO);
    }
}
