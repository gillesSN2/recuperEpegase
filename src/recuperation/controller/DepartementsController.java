package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.DepartementsDTO;
import com.yewi.yewicore.recuperation.service.DepartementsService;
import com.yewi.yewicore.recuperation.vo.DepartementsQueryVO;
import com.yewi.yewicore.recuperation.vo.DepartementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.DepartementsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/departements")
public class DepartementsController {

    @Autowired
    private DepartementsService departementsService;

    @PostMapping
    public String save(@Valid @RequestBody DepartementsVO vO) {
        return departementsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        departementsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DepartementsUpdateVO vO) {
        departementsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DepartementsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return departementsService.getById(id);
    }

    @GetMapping
    public Page<DepartementsDTO> query(@Valid DepartementsQueryVO vO) {
        return departementsService.query(vO);
    }
}
