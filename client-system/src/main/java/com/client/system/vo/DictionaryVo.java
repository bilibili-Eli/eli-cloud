package com.client.system.vo;

import com.client.system.model.Dictionary;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class DictionaryVo extends Dictionary {
    /**
     * 子类集合
     */
    private List<Dictionary> children;
}
