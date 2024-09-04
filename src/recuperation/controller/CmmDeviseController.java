package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmDeviseDTO;
import com.yewi.yewicore.recuperation.service.CmmDeviseService;
import com.yewi.yewicore.recuperation.vo.CmmDeviseQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmDeviseUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmDeviseVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmDevise")
public class CmmDeviseController {

    @Autowired
    private CmmDeviseService cmmDeviseService;

    @PostMapping
    public String save(@Valid @RequestBody CmmDeviseVO vO) {
        return cmmDeviseService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        cmmDeviseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CmmDeviseUpdateVO vO) {
        cmmDeviseService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmDeviseDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return cmmDeviseService.getById(id);
    }

    @GetMapping
    public Page<CmmDeviseDTO> query(@Valid CmmDeviseQueryVO vO) {
        return cmmDeviseService.query(vO);
    }
}
