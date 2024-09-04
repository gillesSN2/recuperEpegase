package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesMissionsDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesMissionsService;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesMissions")
public class PaySalariesMissionsController {

    @Autowired
    private PaySalariesMissionsService paySalariesMissionsService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesMissionsVO vO) {
        return paySalariesMissionsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesMissionsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesMissionsUpdateVO vO) {
        paySalariesMissionsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesMissionsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesMissionsService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesMissionsDTO> query(@Valid PaySalariesMissionsQueryVO vO) {
        return paySalariesMissionsService.query(vO);
    }
}
