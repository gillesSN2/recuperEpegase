package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ImmBienTravauxLigneDTO;
import com.yewi.yewicore.recuperation.service.ImmBienTravauxLigneService;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/immBienTravauxLigne")
public class ImmBienTravauxLigneController {

    @Autowired
    private ImmBienTravauxLigneService immBienTravauxLigneService;

    @PostMapping
    public String save(@Valid @RequestBody ImmBienTravauxLigneVO vO) {
        return immBienTravauxLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        immBienTravauxLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ImmBienTravauxLigneUpdateVO vO) {
        immBienTravauxLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ImmBienTravauxLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return immBienTravauxLigneService.getById(id);
    }

    @GetMapping
    public Page<ImmBienTravauxLigneDTO> query(@Valid ImmBienTravauxLigneQueryVO vO) {
        return immBienTravauxLigneService.query(vO);
    }
}
