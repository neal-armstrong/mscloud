package per.neal.learn.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import per.neal.learn.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444, "按客户自定义,global---version1");
    }

    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "按客户自定义,global---version2");
    }

}
