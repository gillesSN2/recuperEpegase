package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ImmBienFactureDTO;
import com.yewi.yewicore.recuperation.service.ImmBienFactureService;
import com.yewi.yewicore.recuperation.vo.ImmBienFactureQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienFactureUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienFactureVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/immBienFacture")
public class ImmBienFactureController {

    @Autowired
    private ImmBienFactureService immBienFactureService;

    @PostMapping
    public String save(@Valid @RequestBody ImmBienFactureVO vO) {
        return immBienFactureService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        immBienFactureService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ImmBienFactureUpdateVO vO) {
        immBienFactureService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ImmBienFactureDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return immBienFactureService.getById(id);
    }

    @GetMapping
    public Page<ImmBienFactureDTO> query(@Valid ImmBienFactureQueryVO vO) {
        return immBienFactureService.query(vO);
    }
}
