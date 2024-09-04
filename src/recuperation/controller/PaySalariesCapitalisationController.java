package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesCapitalisationDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesCapitalisationService;
import com.yewi.yewicore.recuperation.vo.PaySalariesCapitalisationQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCapitalisationUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCapitalisationVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesCapitalisation")
public class PaySalariesCapitalisationController {

    @Autowired
    private PaySalariesCapitalisationService paySalariesCapitalisationService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesCapitalisationVO vO) {
        return paySalariesCapitalisationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesCapitalisationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesCapitalisationUpdateVO vO) {
        paySalariesCapitalisationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesCapitalisationDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesCapitalisationService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesCapitalisationDTO> query(@Valid PaySalariesCapitalisationQueryVO vO) {
        return paySalariesCapitalisationService.query(vO);
    }
}
