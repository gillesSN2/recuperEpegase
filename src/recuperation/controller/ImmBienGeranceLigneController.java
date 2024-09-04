package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ImmBienGeranceLigneDTO;
import com.yewi.yewicore.recuperation.service.ImmBienGeranceLigneService;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/immBienGeranceLigne")
public class ImmBienGeranceLigneController {

    @Autowired
    private ImmBienGeranceLigneService immBienGeranceLigneService;

    @PostMapping
    public String save(@Valid @RequestBody ImmBienGeranceLigneVO vO) {
        return immBienGeranceLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        immBienGeranceLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ImmBienGeranceLigneUpdateVO vO) {
        immBienGeranceLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ImmBienGeranceLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return immBienGeranceLigneService.getById(id);
    }

    @GetMapping
    public Page<ImmBienGeranceLigneDTO> query(@Valid ImmBienGeranceLigneQueryVO vO) {
        return immBienGeranceLigneService.query(vO);
    }
}
