package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmGroupeFavorisDTO;
import com.yewi.yewicore.recuperation.service.CmmGroupeFavorisService;
import com.yewi.yewicore.recuperation.vo.CmmGroupeFavorisQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeFavorisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeFavorisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmGroupeFavoris")
public class CmmGroupeFavorisController {

    @Autowired
    private CmmGroupeFavorisService cmmGroupeFavorisService;

    @PostMapping
    public String save(@Valid @RequestBody CmmGroupeFavorisVO vO) {
        return cmmGroupeFavorisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmGroupeFavorisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmGroupeFavorisUpdateVO vO) {
        cmmGroupeFavorisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmGroupeFavorisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmGroupeFavorisService.getById(id);
    }

    @GetMapping
    public Page<CmmGroupeFavorisDTO> query(@Valid CmmGroupeFavorisQueryVO vO) {
        return cmmGroupeFavorisService.query(vO);
    }
}
