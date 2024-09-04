package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedProtocoleDTO;
import com.yewi.yewicore.recuperation.service.MedProtocoleService;
import com.yewi.yewicore.recuperation.vo.MedProtocoleQueryVO;
import com.yewi.yewicore.recuperation.vo.MedProtocoleUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedProtocoleVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medProtocole")
public class MedProtocoleController {

    @Autowired
    private MedProtocoleService medProtocoleService;

    @PostMapping
    public String save(@Valid @RequestBody MedProtocoleVO vO) {
        return medProtocoleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medProtocoleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedProtocoleUpdateVO vO) {
        medProtocoleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedProtocoleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medProtocoleService.getById(id);
    }

    @GetMapping
    public Page<MedProtocoleDTO> query(@Valid MedProtocoleQueryVO vO) {
        return medProtocoleService.query(vO);
    }
}
