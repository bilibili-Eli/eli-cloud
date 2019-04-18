package com.client.system.vo;

import com.client.system.model.EliModel;
import com.client.system.model.Schemata;
import com.client.system.model.Sql;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "menus")
public class SqlVo extends Sql {
    private String schemaName;
    private String tableName;
}
