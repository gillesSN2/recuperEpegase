package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedCcamDTO;
import com.yewi.yewicore.recuperation.service.MedCcamService;
import com.yewi.yewicore.recuperation.vo.MedCcamQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCcamUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCcamVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medCcam")
public class MedCcamController {

    @Autowired
    private MedCcamService medCcamService;

    @PostMapping
    public String save(@Valid @RequestBody MedCcamVO vO) {
        return medCcamService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medCcamService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedCcamUpdateVO vO) {
        medCcamService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedCcamDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medCcamService.getById(id);
    }

    @GetMapping
    public Page<MedCcamDTO> query(@Valid MedCcamQueryVO vO) {
        return medCcamService.query(vO);
    }
}
