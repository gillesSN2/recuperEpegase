package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesPretsDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesPretsService;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesPrets")
public class PaySalariesPretsController {

    @Autowired
    private PaySalariesPretsService paySalariesPretsService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesPretsVO vO) {
        return paySalariesPretsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesPretsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesPretsUpdateVO vO) {
        paySalariesPretsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesPretsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesPretsService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesPretsDTO> query(@Valid PaySalariesPretsQueryVO vO) {
        return paySalariesPretsService.query(vO);
    }
}
