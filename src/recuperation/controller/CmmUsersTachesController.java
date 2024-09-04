package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmUsersTachesDTO;
import com.yewi.yewicore.recuperation.service.CmmUsersTachesService;
import com.yewi.yewicore.recuperation.vo.CmmUsersTachesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersTachesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersTachesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmUsersTaches")
public class CmmUsersTachesController {

    @Autowired
    private CmmUsersTachesService cmmUsersTachesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmUsersTachesVO vO) {
        return cmmUsersTachesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmUsersTachesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmUsersTachesUpdateVO vO) {
        cmmUsersTachesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmUsersTachesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmUsersTachesService.getById(id);
    }

    @GetMapping
    public Page<CmmUsersTachesDTO> query(@Valid CmmUsersTachesQueryVO vO) {
        return cmmUsersTachesService.query(vO);
    }
}
