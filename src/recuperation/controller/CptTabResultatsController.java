package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptTabResultatsDTO;
import com.yewi.yewicore.recuperation.service.CptTabResultatsService;
import com.yewi.yewicore.recuperation.vo.CptTabResultatsQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabResultatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabResultatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptTabResultats")
public class CptTabResultatsController {

    @Autowired
    private CptTabResultatsService cptTabResultatsService;

    @PostMapping
    public String save(@Valid @RequestBody CptTabResultatsVO vO) {
        return cptTabResultatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptTabResultatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptTabResultatsUpdateVO vO) {
        cptTabResultatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptTabResultatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptTabResultatsService.getById(id);
    }

    @GetMapping
    public Page<CptTabResultatsDTO> query(@Valid CptTabResultatsQueryVO vO) {
        return cptTabResultatsService.query(vO);
    }
}
