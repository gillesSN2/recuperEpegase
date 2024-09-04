package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmUsersDTO;
import com.yewi.yewicore.recuperation.service.CmmUsersService;
import com.yewi.yewicore.recuperation.vo.CmmUsersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmUsersVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmUsers")
public class CmmUsersController {

    @Autowired
    private CmmUsersService cmmUsersService;

    @PostMapping
    public String save(@Valid @RequestBody CmmUsersVO vO) {
        return cmmUsersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmUsersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmUsersUpdateVO vO) {
        cmmUsersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmUsersDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmUsersService.getById(id);
    }

    @GetMapping
    public Page<CmmUsersDTO> query(@Valid CmmUsersQueryVO vO) {
        return cmmUsersService.query(vO);
    }
}
