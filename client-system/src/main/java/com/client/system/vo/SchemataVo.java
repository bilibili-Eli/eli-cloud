package com.client.system.vo;

import com.client.system.model.Schemata;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class SchemataVo extends Schemata {
    private List<Schemata> children;
}
