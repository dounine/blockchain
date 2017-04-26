package com.dounine.blockchain.action.demo;

import com.dounine.blockchain.result.ActResult;
import com.dounine.blockchain.result.Result;
import com.dounine.blockchain.security.TestVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试功能
 * Created by lake on 17-4-19.
 */
@RestController
public class TestAction {

    /**
     * 测试例子
     * @userToken yes
     * @version v1
     * @return class TestVo
     */
    @PostMapping("v1/test")
    public Result test(@Validated({TestVo.TestA.class}) TestVo testVo){
        return new ActResult("成功");
    }


}
