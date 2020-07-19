package com.zydata.controller.master;

import com.zydata.config.MasterConfigMessage;
import com.zydata.entity.master.ManagerEntity;
import com.zydata.exception.master.MasterException;
import com.zydata.service.master.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/zyadmin")
public class MasterController {
    @Autowired
    MasterService masterService;

    @RequestMapping("/master")
    public String master(Model model,ManagerEntity entity)throws MasterException{
        try {
            masterService.masterRegister(entity);
        }catch (Exception e){
            throw new MasterException(MasterConfigMessage.MASTER_ADD_SUCCESS);
        }
        return "admin/index";
    }
    @RequestMapping("/masterdede")
    public String masterdede(Integer uid)throws MasterException{
        if(masterService.deleteMaster(uid)!=1){
            throw  new MasterException(MasterConfigMessage.FAIL_TO_DEDELET);
        }
        return "admin/index";
    }

    @RequestMapping("/masterupdate")
    public String masterupdate(Integer uid,ManagerEntity entity) throws MasterException{
        if(masterService.modifyActor(uid,entity)!=1){
            throw  new MasterException(MasterConfigMessage.UPDATE_MASTER);
        }
        return "admin/index";
    }


    @RequestMapping("/listmaster")
    public List<ManagerEntity> getMaster()throws MasterException{
             if(masterService.getMaster()==null){
                 throw  new MasterException(MasterConfigMessage.FAIL_TO_GET);
             }else {
                 return masterService.getMaster();
             }

    }

}

