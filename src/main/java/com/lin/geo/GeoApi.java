package com.lin.geo;

import com.dengxq.lnglat2Geo.GeoTrans;
import com.dengxq.lnglat2Geo.entity.Admin;
import com.dengxq.lnglat2Geo.entity.CoordinateSystem;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("geo/")
@RestController
@Slf4j
public class GeoApi implements InitializingBean {

  @GetMapping("/")
  public Admin test(
      @RequestParam("la") Double la,
      @RequestParam("lb") Double lb,
      HttpServletRequest request
  ) {

    Admin admin = GeoTrans.determineAdmin(la, lb, CoordinateSystem.BD09(), true);
    return admin;
  }


  @Override
  public void afterPropertiesSet() throws Exception {
    GeoTrans.init(true, false, false, false);
  }
}
