package com.client.system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class Meta {
    @Column(name = "title")
    private String title;
    @Column(name = "icon")
    private String icon;
}
