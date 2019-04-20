/**
 * FileName: AccessToken
 * Author:   13235
 * Date:     2019/3/30 17:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.domain;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/30
 * @since 1.0.0
 */
@Data
public class AccessToken {
    /**
     * 凭证
     */
    private String tokenName;
    /**
     * 有效期:单位秒
     */
    private Long expireSecond;

}
