package com.ranjun1999.personalutils.service;

import com.ranjun1999.personalutils.model.FinalSolution;
import com.ranjun1999.personalutils.model.Solution;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/5/21 10:06
 */
public interface QuestionService {

    int addQuestion(String questionName);

    List<Solution> executeRunPath(int questionId, int choice);

    void selectFinalPath(FinalSolution finalSolution);
}
