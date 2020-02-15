package top.amfun.refer.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create By chengming on 2020/2/15 9:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferException extends RuntimeException{

    private Integer code;
    private String message;
}
