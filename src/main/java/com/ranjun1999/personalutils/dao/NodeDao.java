package com.ranjun1999.personalutils.dao;

import com.ranjun1999.personalutils.model.Node;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/5/21 10:14
 */
public interface NodeDao {


    void addNodes(List<Node> nodes);

    void delNode(int nodeId);

    void modifyNode(Node node);
}
