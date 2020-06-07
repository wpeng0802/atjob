package com.bzb.atjob.app.auth.core.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "部门")
@Getter
@Setter
public class Dept {
    @ApiModelProperty(value = "DEPT_ID", required = false)
    private String deptId;

    @ApiModelProperty(value = "部门名称", required = false)
    private String name;

    @ApiModelProperty(value = "部门编码", required = false)
    private String code;

    @ApiModelProperty(value = "父节ID", required = false)
    private String parent;

    @ApiModelProperty(value = "录入码", required = false)
    private String inputCode;

    @ApiModelProperty(value = "排序", required = false)
    private Integer indexField;

    @ApiModelProperty(value = "描述", required = false)
    private String description;

    @ApiModelProperty(value = "是否停用", required = false)
    private Boolean isStop;

    @ApiModelProperty(value = "创建时间", required = false)
    private Date createTime;

    @ApiModelProperty(value = "创建人Id@AUTH_USER", required = false)
    private String createUserId;

    @ApiModelProperty(value = "修改人id@AUTH_USER", required = false)
    private String modifyUserId;

    @ApiModelProperty(value = "修改时间", required = false)
    private Date modifyTime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", parent=").append(parent);
        sb.append(", inputCode=").append(inputCode);
        sb.append(", indexField=").append(indexField);
        sb.append(", description=").append(description);
        sb.append(", isStop=").append(isStop);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", modifyUserId=").append(modifyUserId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}