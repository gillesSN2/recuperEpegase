package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmModeleCourriersDTO;
import com.yewi.yewicore.recuperation.service.CmmModeleCourriersService;
import com.yewi.yewicore.recuperation.vo.CmmModeleCourriersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmModeleCourriersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmModeleCourriersVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmModeleCourriers")
public class CmmModeleCourriersController {

    @Autowired
    private CmmModeleCourriersService cmmModeleCourriersService;

    @PostMapping
    public String save(@Valid @RequestBody CmmModeleCourriersVO vO) {
        return cmmModeleCourriersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmModeleCourriersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmModeleCourriersUpdateVO vO) {
        cmmModeleCourriersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmModeleCourriersDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmModeleCourriersService.getById(id);
    }

    @GetMapping
    public Page<CmmModeleCourriersDTO> query(@Valid CmmModeleCourriersQueryVO vO) {
        return cmmModeleCourriersService.query(vO);
    }
}
