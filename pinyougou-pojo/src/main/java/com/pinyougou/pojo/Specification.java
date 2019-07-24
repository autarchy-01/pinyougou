package com.pinyougou.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Table(name = "tb_specification")
@Data
public class Specification implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "spec_name")
    private String specName;

    @Column(name = "spec_status")
    private String specStatus;

    private static final long serialVersionUID = 1L;
}