package com.client.system.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "menus")
public class Menus extends EliModel {
    @Id
    @Column(name = "menu_id")
    private String menuId;
    @Column(name = "parent_id")
    private String parentId;
    @Column(name = "is_parent")
    private String isParent;
    @Column(name = "path")
    private String path;
    @Column(name = "redirect")
    private String redirect;
    @Column(name = "name")
    private String name;
    @Column(name = "component")
    private String component;
    @Column(name = "title")
    private String title;
    @Column(name = "icon")
    private String icon;
}
