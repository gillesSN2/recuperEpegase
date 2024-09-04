package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmMetiersDTO;
import com.yewi.yewicore.recuperation.service.CmmMetiersService;
import com.yewi.yewicore.recuperation.vo.CmmMetiersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMetiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMetiersVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmMetiers")
public class CmmMetiersController {

    @Autowired
    private CmmMetiersService cmmMetiersService;

    @PostMapping
    public String save(@Valid @RequestBody CmmMetiersVO vO) {
        return cmmMetiersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmMetiersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmMetiersUpdateVO vO) {
        cmmMetiersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmMetiersDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmMetiersService.getById(id);
    }

    @GetMapping
    public Page<CmmMetiersDTO> query(@Valid CmmMetiersQueryVO vO) {
        return cmmMetiersService.query(vO);
    }
}
