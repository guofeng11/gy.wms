package com.gy.wms;


import com.gy.upms.dto.application.AppRegisterResult;
import com.gy.upms.services.duplex.AppService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * @Auther: guofeng
 * @Date: 2019/6/6 13:17
 * @Description: 应用程序启动 获取应用授权信息
 */
@Component
@Order(1)
public class AppAuthRunner implements ApplicationRunner {

    private static final Logger log= LoggerFactory.getLogger(AppAuthRunner.class);

    @Reference(version = "${duplex.service.version}", url = "${duplex.service.url}")
    private AppService appService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("启动后执行");
        AppRegisterResult appRegisterResult= appService.register("1111");
        log.debug(appRegisterResult.toString());
//        //启动加载授权信息
//        AppAndAuthInfo appAuthInfos =VerifyUtils.getAppAuth(ApplicationProperties.getAppToken());
//        //初始化权限
//        VerifyUtils.getAppPerm(ApplicationProperties.getAppToken());
//        //授权系统需从数据库初始化
//        if (appAuthInfos.getAppInfo()==null){
//            log.info("服务启动失败,未获取到配置信息");
//        }
    }
}
