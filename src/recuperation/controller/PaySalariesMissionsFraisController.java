package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesMissionsFraisDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesMissionsFraisService;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsFraisQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsFraisUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesMissionsFraisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesMissionsFrais")
public class PaySalariesMissionsFraisController {

    @Autowired
    private PaySalariesMissionsFraisService paySalariesMissionsFraisService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesMissionsFraisVO vO) {
        return paySalariesMissionsFraisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesMissionsFraisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesMissionsFraisUpdateVO vO) {
        paySalariesMissionsFraisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesMissionsFraisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesMissionsFraisService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesMissionsFraisDTO> query(@Valid PaySalariesMissionsFraisQueryVO vO) {
        return paySalariesMissionsFraisService.query(vO);
    }
}
