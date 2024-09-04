package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayMissionsDTO;
import com.yewi.yewicore.recuperation.service.PayMissionsService;
import com.yewi.yewicore.recuperation.vo.PayMissionsQueryVO;
import com.yewi.yewicore.recuperation.vo.PayMissionsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayMissionsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payMissions")
public class PayMissionsController {

    @Autowired
    private PayMissionsService payMissionsService;

    @PostMapping
    public String save(@Valid @RequestBody PayMissionsVO vO) {
        return payMissionsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payMissionsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayMissionsUpdateVO vO) {
        payMissionsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayMissionsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payMissionsService.getById(id);
    }

    @GetMapping
    public Page<PayMissionsDTO> query(@Valid PayMissionsQueryVO vO) {
        return payMissionsService.query(vO);
    }
}
