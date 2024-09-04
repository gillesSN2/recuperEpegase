package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchReceptionSerieDTO;
import com.yewi.yewicore.recuperation.service.AchReceptionSerieService;
import com.yewi.yewicore.recuperation.vo.AchReceptionSerieQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionSerieUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionSerieVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achReceptionSerie")
public class AchReceptionSerieController {

    @Autowired
    private AchReceptionSerieService achReceptionSerieService;

    @PostMapping
    public String save(@Valid @RequestBody AchReceptionSerieVO vO) {
        return achReceptionSerieService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achReceptionSerieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchReceptionSerieUpdateVO vO) {
        achReceptionSerieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchReceptionSerieDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achReceptionSerieService.getById(id);
    }

    @GetMapping
    public Page<AchReceptionSerieDTO> query(@Valid AchReceptionSerieQueryVO vO) {
        return achReceptionSerieService.query(vO);
    }
}
