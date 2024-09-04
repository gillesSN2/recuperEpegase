package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.UtilisateursModulesesDTO;
import com.yewi.yewicore.recuperation.service.UtilisateursModulesesService;
import com.yewi.yewicore.recuperation.vo.UtilisateursModulesesQueryVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursModulesesUpdateVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursModulesesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/utilisateursModuleses")
public class UtilisateursModulesesController {

    @Autowired
    private UtilisateursModulesesService utilisateursModulesesService;

    @PostMapping
    public String save(@Valid @RequestBody UtilisateursModulesesVO vO) {
        return utilisateursModulesesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        utilisateursModulesesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody UtilisateursModulesesUpdateVO vO) {
        utilisateursModulesesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UtilisateursModulesesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return utilisateursModulesesService.getById(id);
    }

    @GetMapping
    public Page<UtilisateursModulesesDTO> query(@Valid UtilisateursModulesesQueryVO vO) {
        return utilisateursModulesesService.query(vO);
    }
}
