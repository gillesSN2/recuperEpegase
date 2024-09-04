package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchDepotDTO;
import com.yewi.yewicore.recuperation.service.AchDepotService;
import com.yewi.yewicore.recuperation.vo.AchDepotQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDepotUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDepotVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achDepot")
public class AchDepotController {

    @Autowired
    private AchDepotService achDepotService;

    @PostMapping
    public String save(@Valid @RequestBody AchDepotVO vO) {
        return achDepotService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achDepotService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchDepotUpdateVO vO) {
        achDepotService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchDepotDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achDepotService.getById(id);
    }

    @GetMapping
    public Page<AchDepotDTO> query(@Valid AchDepotQueryVO vO) {
        return achDepotService.query(vO);
    }
}
