export class TreeUtil {
  /**
   * 将数组形式的 data 构建为树形结构
   * @param data 数组形式的实体列表
   * @param idName Id 属性名
   * @param parentIdName 父节点Id属性名
   */
  static buildTree(data: any[], idName, parentIdName, labelName = 'name', titleName = 'name') {
    const attachChildNodes = (nodeList: any[], node) => {
      const childNodes = nodeList.filter((d) => d[parentIdName] === node[idName]);
      node.key = node[idName];
      node.value = node[idName];
      node.label = node[labelName];
      node.title = node[titleName];
      node.children = childNodes;
      node.isLeaf = childNodes.length <= 0;

      for (const childNode of childNodes) {
        childNode.parentNode = node;
        attachChildNodes(nodeList, childNode);
      }
    };

    const rootNodes = data.filter((d) => d[parentIdName] == null);
    for (const rootNode of rootNodes) {
      attachChildNodes(data, rootNode);
    }

    return rootNodes;
  }

  /**
   * 返回树节点中选中的叶子节点 key 值列表
   */
  static getCheckedLeafKeys(nodes) {
    const getCheckedLeafKeysOfNode = (node) => {
      const checkedLeafKeys = [];
      if (node.isLeaf && node.checked) {
        checkedLeafKeys.push(node.key);
      }

      if (node.children && node.children.length) {
        const checkedLeafKeysOfChildren = node.children.reduce((result, child) => {
          result.push(...getCheckedLeafKeysOfNode(child));
          return result;
        }, []);

        checkedLeafKeys.push(...checkedLeafKeysOfChildren);
      }

      return checkedLeafKeys;
    };

    return nodes.reduce((result, node) => {
      result.push(...getCheckedLeafKeysOfNode(node));
      return result;
    }, []);
  }

  /**
   * 获取当前节点 node 所有上级节点的 Id 列表
   */
  static getParentIdList(node, idName): string[] {
    const appendParentId = (nodeParam, idNameParam): string[] => {
      if (nodeParam.parentNode) {
        return [...appendParentId(nodeParam.parentNode, idNameParam), nodeParam[idNameParam]];
      } else {
        return [nodeParam[idNameParam]];
      }
    };

    return appendParentId(node, idName);
  }

  /**
   * 从树中查找匹配 Id 的节点
   * @param rootNodes 树根节点列表
   * @param idValue Id 值
   * @param idName Id 属性名称
   */
  static findNodeById(rootNodes: any[], idValue, idName) {
    let result = null;
    for (const node of rootNodes) {
      if (node[idName] === idValue) {
        result = node;
      } else if (node.children && node.children.length) {
        const childNode = this.findNodeById(node.children, idValue, idName);
        if (childNode) {
          result = childNode;
        }
      }
    }
    return result;
  }
}
