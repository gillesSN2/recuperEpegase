package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesGrhDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesGrhService;
import com.yewi.yewicore.recuperation.vo.PaySalariesGrhQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesGrhUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesGrhVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesGrh")
public class PaySalariesGrhController {

    @Autowired
    private PaySalariesGrhService paySalariesGrhService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesGrhVO vO) {
        return paySalariesGrhService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesGrhService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesGrhUpdateVO vO) {
        paySalariesGrhService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesGrhDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesGrhService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesGrhDTO> query(@Valid PaySalariesGrhQueryVO vO) {
        return paySalariesGrhService.query(vO);
    }
}
