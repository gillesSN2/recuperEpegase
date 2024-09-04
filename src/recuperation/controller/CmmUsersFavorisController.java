package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmUsersFavorisDTO;
import com.yewi.yewicore.recuperation.service.CmmUsersFavorisService;
import com.yewi.yewicore.recuperation.vo.CmmUsersFavorisQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersFavorisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersFavorisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmUsersFavoris")
public class CmmUsersFavorisController {

    @Autowired
    private CmmUsersFavorisService cmmUsersFavorisService;

    @PostMapping
    public String save(@Valid @RequestBody CmmUsersFavorisVO vO) {
        return cmmUsersFavorisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmUsersFavorisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmUsersFavorisUpdateVO vO) {
        cmmUsersFavorisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmUsersFavorisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmUsersFavorisService.getById(id);
    }

    @GetMapping
    public Page<CmmUsersFavorisDTO> query(@Valid CmmUsersFavorisQueryVO vO) {
        return cmmUsersFavorisService.query(vO);
    }
}
