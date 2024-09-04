package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchCotationsLigneDTO;
import com.yewi.yewicore.recuperation.service.AchCotationsLigneService;
import com.yewi.yewicore.recuperation.vo.AchCotationsLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCotationsLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achCotationsLigne")
public class AchCotationsLigneController {

    @Autowired
    private AchCotationsLigneService achCotationsLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchCotationsLigneVO vO) {
        return achCotationsLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achCotationsLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchCotationsLigneUpdateVO vO) {
        achCotationsLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchCotationsLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achCotationsLigneService.getById(id);
    }

    @GetMapping
    public Page<AchCotationsLigneDTO> query(@Valid AchCotationsLigneQueryVO vO) {
        return achCotationsLigneService.query(vO);
    }
}
