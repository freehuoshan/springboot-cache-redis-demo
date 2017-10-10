package net.test;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class TestService {

    /**
     * 固定key
     *
     * @return
     * @author SHANHY
     * @create  2017年4月9日
     */
    @Cacheable(value = RedisKeys._CACHE_TEST, key = "'" + RedisKeys._CACHE_TEST + "'")
    public String testCache() {
        return RandomStringUtils.randomNumeric(4);
    }

    /**
     * 存储在Redis中的key自动生成，生成规则详见CachingConfig.keyGenerator()方法
     *
     * @param str1
     * @param str2
     * @return
     * @author SHANHY
     * @create  2017年4月9日
     */
    @Cacheable(value = RedisKeys._CACHE_TEST)
    public Map<String,Object> testCache2(String str1, String str2) {
    	Map<String,Object> restMap = new HashMap<String, Object>();
    	restMap.put("1", str1);
    	restMap.put("2", str2);
        return restMap;
    }
}