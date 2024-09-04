package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesElementsDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesElementsService;
import com.yewi.yewicore.recuperation.vo.PaySalariesElementsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesElementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesElementsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesElements")
public class PaySalariesElementsController {

    @Autowired
    private PaySalariesElementsService paySalariesElementsService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesElementsVO vO) {
        return paySalariesElementsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesElementsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesElementsUpdateVO vO) {
        paySalariesElementsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesElementsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesElementsService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesElementsDTO> query(@Valid PaySalariesElementsQueryVO vO) {
        return paySalariesElementsService.query(vO);
    }
}
