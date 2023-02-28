package geno.ms.ui.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("api-gateway")
//@FeignClient(value="stream-api", url="${api-gateway.url}")
//@FeignClient("STREAM-SERVICE/stream")
public interface DataStreamClient {

    @RequestMapping("/stream/api/load/{uuid}")
    DataStreamModel loadData(@PathVariable String uuid);

    @RequestMapping("/stream/api/load")
    List<DataStreamModel> loadDatas();
}
