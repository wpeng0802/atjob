package com.bzb.atjob.app.auth.core.role.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bzb.atjob.app.auth.adaptor.finder.FindRoleById;
import com.bzb.atjob.app.auth.adaptor.mapper.PageOwnedByRoleMapper;
import com.bzb.atjob.app.auth.adaptor.mapper.RoleMapper;
import com.bzb.atjob.app.auth.core.role.model.PageOwnedByRole;
import com.bzb.atjob.app.auth.core.role.model.Role;
import com.bzb.atjob.common.util.MybatisUtil;
import com.bzb.atjob.common.vo.PaggingResult;
import java.util.List;
import javax.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleRepository implements FindRoleById {

  private final RoleMapper roleMapper;

  private final PageOwnedByRoleMapper pageOwnedByRoleMapper;

  /**
   * 获取匹配主键的角色.
   *
   * @param id 主键
   * @return
   */
  public Role byId(String id) {
    Role entity = roleMapper.selectById(id);

    var pagesOwend =
        pageOwnedByRoleMapper.selectList(
            new LambdaQueryWrapper<PageOwnedByRole>().eq(PageOwnedByRole::getRoleId, id));
    entity.setPagesOwned(pagesOwend);

    return entity;
  }

  /**
   * 保存或更新角色.
   *
   * @param entity 角色实体
   */
  public void save(Role entity) {
    // 验证编码不允许重复
    if (this.isRoleExists(entity.getRoleId(), entity.getCode())) {
      throw new ValidationException("编码不允许重复！");
    }

    if (StringUtils.isBlank(entity.getRoleId())) {
      roleMapper.insert(entity);
      this.savePagesOwned(entity.getRoleId(), entity.getPagesOwned());
    } else {
      roleMapper.updateById(entity);
      this.savePagesOwned(entity.getRoleId(), entity.getPagesOwned());
    }
  }

  private void savePagesOwned(String roleId, List<PageOwnedByRole> pagesOwned) {
    pageOwnedByRoleMapper.delete(
        new LambdaQueryWrapper<PageOwnedByRole>().eq(PageOwnedByRole::getRoleId, roleId));
    if (pagesOwned != null) {
      for (PageOwnedByRole pageOwnedByRole : pagesOwned) {
        pageOwnedByRoleMapper.insert(pageOwnedByRole);
      }
    }
  }

  /** 删除角色. */
  public void delete(String id) {
    roleMapper.deleteById(id);
    pageOwnedByRoleMapper.delete(
        new LambdaQueryWrapper<PageOwnedByRole>().eq(PageOwnedByRole::getRoleId, id));
  }

  /** 删除所有角色对 pageId 的关联. */
  public void deleteAllOwnedPages(String pageId) {
    pageOwnedByRoleMapper.delete(
        new LambdaQueryWrapper<PageOwnedByRole>().eq(PageOwnedByRole::getPageId, pageId));
  }

  /**
   * 获取角色列表.
   *
   * @param pageNum 页码
   * @param pageSize 每页条数
   * @param sort 排序
   * @param query 模糊查询字符串
   */
  public PaggingResult<Role> getRoleList(Long pageNum, Long pageSize, String sort, String query) {
    Page<Role> page = MybatisUtil.createPage(pageNum, pageSize);

    // 排序
    MybatisUtil.getOrderItemList(sort, Role.class, true).stream().forEach(page::addOrder);

    // 筛选
    QueryWrapper<Role> wrapper = new QueryWrapper<Role>();
    wrapper
        .lambda()
        .nested(
            w ->
                w.like(Role::getName, query)
                    .or()
                    .like(Role::getCode, StringUtils.defaultString(query)));

    roleMapper.selectPage(page, wrapper);

    return new PaggingResult<Role>(page.getRecords(), page.getSize());
  }

  /** 判断角色是否已存在. */
  private boolean isRoleExists(String roldId, String code) {
    if (StringUtils.isBlank(roldId)) {
      return roleMapper.selectCount(new QueryWrapper<Role>().lambda().eq(Role::getCode, code)) > 0;
    } else {
      return roleMapper.selectCount(
              new QueryWrapper<Role>().lambda().ne(Role::getRoleId, roldId).eq(Role::getCode, code))
          > 0;
    }
  }

  @Override
  public Role findRoleById(String roleId) {
    return byId(roleId);
  }
}
