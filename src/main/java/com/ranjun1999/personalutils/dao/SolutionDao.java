package com.ranjun1999.personalutils.dao;

import com.ranjun1999.personalutils.model.FinalSolution;
import com.ranjun1999.personalutils.model.Solution;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/5/21 10:45
 */
public interface SolutionDao {

    void addSolutions(List<Solution>solutions);

    void modifySolution(Solution solution);

    Solution getSolution(int solutionId);

    List<Solution> selectSolutions(int questionId);

    FinalSolution getFinaSolution(int fsId);
}
