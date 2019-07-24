package com.pinyougou.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Table(name = "tb_brand")
@Data
public class Brand implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 品牌名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 品牌首字母
     */
    @Column(name = "first_char")
    private String firstChar;

    @Column(name = "status")
    private String status;

    private static final long serialVersionUID = 1L;
}