package com.gy.wms.servicesimp.duplexImp;

import com.gy.upms.services.duplex.AppService;
import org.apache.dubbo.config.annotation.Reference;

/**
 * @Auther: guofeng
 * @Date: 2019/7/1 10:02
 * @Description:
 */

public class appServiceImp {

    @Reference(version = "${duplex.service.version}", url = "${duplex.service.url}")
    private AppService appService;
}
