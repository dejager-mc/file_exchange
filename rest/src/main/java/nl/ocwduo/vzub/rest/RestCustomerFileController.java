package nl.ocwduo.vzub.rest;

import nl.ocwduo.vzub.domain.CustomerFile;
import nl.ocwduo.vzub.service.CustomerFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Machiel de Jager on 26-2-2016.
 */
@Controller
public class RestCustomerFileController {

    private CustomerFileService customerFileService;

    @Autowired
    public RestCustomerFileController(CustomerFileService customerFileService) {
        this.customerFileService = customerFileService;
    }

    @ResponseBody
    @RequestMapping("/customer/*/{fileid}")
    public ResponseEntity<CustomerFile> getCustomerFile(@PathVariable("fileid") long fileId) {
        CustomerFile file = customerFileService.findFileById(fileId);
        if (file != null) {
            return new ResponseEntity<CustomerFile>(file, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
