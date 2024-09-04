package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmBaremesDTO;
import com.yewi.yewicore.recuperation.service.CmmBaremesService;
import com.yewi.yewicore.recuperation.vo.CmmBaremesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmBaremesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmBaremesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmBaremes")
public class CmmBaremesController {

    @Autowired
    private CmmBaremesService cmmBaremesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmBaremesVO vO) {
        return cmmBaremesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmBaremesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmBaremesUpdateVO vO) {
        cmmBaremesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmBaremesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmBaremesService.getById(id);
    }

    @GetMapping
    public Page<CmmBaremesDTO> query(@Valid CmmBaremesQueryVO vO) {
        return cmmBaremesService.query(vO);
    }
}
