package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.FamilleClientDTO;
import com.yewi.yewicore.recuperation.service.FamilleClientService;
import com.yewi.yewicore.recuperation.vo.FamilleClientQueryVO;
import com.yewi.yewicore.recuperation.vo.FamilleClientUpdateVO;
import com.yewi.yewicore.recuperation.vo.FamilleClientVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/familleClient")
public class FamilleClientController {

    @Autowired
    private FamilleClientService familleClientService;

    @PostMapping
    public String save(@Valid @RequestBody FamilleClientVO vO) {
        return familleClientService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        familleClientService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody FamilleClientUpdateVO vO) {
        familleClientService.update(id, vO);
    }

    @GetMapping("/{id}")
    public FamilleClientDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return familleClientService.getById(id);
    }

    @GetMapping
    public Page<FamilleClientDTO> query(@Valid FamilleClientQueryVO vO) {
        return familleClientService.query(vO);
    }
}
