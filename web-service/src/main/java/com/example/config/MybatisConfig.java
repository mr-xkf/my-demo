/**
 * FileName: MybatisConfig
 * Author:   13235
 * Date:     2019/3/16 19:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/16
 * @since 1.0.0
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            //可以将字段的下划线自动转成驼峰命名的方式和对象属性映射
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }
}
