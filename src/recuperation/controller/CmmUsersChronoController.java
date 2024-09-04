package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmUsersChronoDTO;
import com.yewi.yewicore.recuperation.service.CmmUsersChronoService;
import com.yewi.yewicore.recuperation.vo.CmmUsersChronoQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersChronoUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersChronoVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmUsersChrono")
public class CmmUsersChronoController {

    @Autowired
    private CmmUsersChronoService cmmUsersChronoService;

    @PostMapping
    public String save(@Valid @RequestBody CmmUsersChronoVO vO) {
        return cmmUsersChronoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmUsersChronoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmUsersChronoUpdateVO vO) {
        cmmUsersChronoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmUsersChronoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmUsersChronoService.getById(id);
    }

    @GetMapping
    public Page<CmmUsersChronoDTO> query(@Valid CmmUsersChronoQueryVO vO) {
        return cmmUsersChronoService.query(vO);
    }
}
