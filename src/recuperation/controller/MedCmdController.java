package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedCmdDTO;
import com.yewi.yewicore.recuperation.service.MedCmdService;
import com.yewi.yewicore.recuperation.vo.MedCmdQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCmdUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCmdVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medCmd")
public class MedCmdController {

    @Autowired
    private MedCmdService medCmdService;

    @PostMapping
    public String save(@Valid @RequestBody MedCmdVO vO) {
        return medCmdService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medCmdService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedCmdUpdateVO vO) {
        medCmdService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedCmdDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medCmdService.getById(id);
    }

    @GetMapping
    public Page<MedCmdDTO> query(@Valid MedCmdQueryVO vO) {
        return medCmdService.query(vO);
    }
}
