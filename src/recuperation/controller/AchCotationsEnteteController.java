package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchCotationsEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchCotationsEnteteService;
import com.yewi.yewicore.recuperation.vo.AchCotationsEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achCotationsEntete")
public class AchCotationsEnteteController {

    @Autowired
    private AchCotationsEnteteService achCotationsEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchCotationsEnteteVO vO) {
        return achCotationsEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achCotationsEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchCotationsEnteteUpdateVO vO) {
        achCotationsEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchCotationsEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achCotationsEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchCotationsEnteteDTO> query(@Valid AchCotationsEnteteQueryVO vO) {
        return achCotationsEnteteService.query(vO);
    }
}
