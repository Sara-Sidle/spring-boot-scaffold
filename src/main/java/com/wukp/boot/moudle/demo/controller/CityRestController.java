package com.wukp.boot.moudle.demo.controller;

import com.wukp.boot.moudle.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 09/29/2017.
 */
@RestController
@RequestMapping(value = "/city")
public class CityRestController {

    @Autowired
    private DemoService demoService;

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Mono<City> findOneCity(@PathVariable("id") Long id) {
//        return Mono.create(cityMonoSink -> cityMonoSink.success(demoService.findByName("")));
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public Flux<City> findAllCity() {
//        return Flux.create(cityFluxSink -> {
//            cityService.findAllCity().forEach(city -> {
//                cityFluxSink.next(city);
//            });
//            cityFluxSink.complete();
//        });
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Mono<Long> createCity(@RequestBody City city) {
//        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.saveCity(city)));
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public Mono<Long> modifyCity(@RequestBody City city) {
//        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.updateCity(city)));
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public Mono<Long> modifyCity(@PathVariable("id") Long id) {
//        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.deleteCity(id)));
//    }
}
