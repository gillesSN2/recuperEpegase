package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ImmBienTravauxEnteteDTO;
import com.yewi.yewicore.recuperation.service.ImmBienTravauxEnteteService;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/immBienTravauxEntete")
public class ImmBienTravauxEnteteController {

    @Autowired
    private ImmBienTravauxEnteteService immBienTravauxEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody ImmBienTravauxEnteteVO vO) {
        return immBienTravauxEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        immBienTravauxEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ImmBienTravauxEnteteUpdateVO vO) {
        immBienTravauxEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ImmBienTravauxEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return immBienTravauxEnteteService.getById(id);
    }

    @GetMapping
    public Page<ImmBienTravauxEnteteDTO> query(@Valid ImmBienTravauxEnteteQueryVO vO) {
        return immBienTravauxEnteteService.query(vO);
    }
}
