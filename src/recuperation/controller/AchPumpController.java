package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchPumpDTO;
import com.yewi.yewicore.recuperation.service.AchPumpService;
import com.yewi.yewicore.recuperation.vo.AchPumpQueryVO;
import com.yewi.yewicore.recuperation.vo.AchPumpUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchPumpVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achPump")
public class AchPumpController {

    @Autowired
    private AchPumpService achPumpService;

    @PostMapping
    public String save(@Valid @RequestBody AchPumpVO vO) {
        return achPumpService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achPumpService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchPumpUpdateVO vO) {
        achPumpService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchPumpDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achPumpService.getById(id);
    }

    @GetMapping
    public Page<AchPumpDTO> query(@Valid AchPumpQueryVO vO) {
        return achPumpService.query(vO);
    }
}
