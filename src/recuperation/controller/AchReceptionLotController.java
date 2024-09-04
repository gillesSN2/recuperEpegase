package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchReceptionLotDTO;
import com.yewi.yewicore.recuperation.service.AchReceptionLotService;
import com.yewi.yewicore.recuperation.vo.AchReceptionLotQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLotUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLotVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achReceptionLot")
public class AchReceptionLotController {

    @Autowired
    private AchReceptionLotService achReceptionLotService;

    @PostMapping
    public String save(@Valid @RequestBody AchReceptionLotVO vO) {
        return achReceptionLotService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achReceptionLotService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchReceptionLotUpdateVO vO) {
        achReceptionLotService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchReceptionLotDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achReceptionLotService.getById(id);
    }

    @GetMapping
    public Page<AchReceptionLotDTO> query(@Valid AchReceptionLotQueryVO vO) {
        return achReceptionLotService.query(vO);
    }
}
