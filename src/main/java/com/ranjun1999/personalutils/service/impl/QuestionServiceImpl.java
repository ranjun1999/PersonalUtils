package com.ranjun1999.personalutils.service.impl;

import com.ranjun1999.personalutils.dao.NodeDao;
import com.ranjun1999.personalutils.dao.QuestionDao;
import com.ranjun1999.personalutils.dao.SolutionDao;
import com.ranjun1999.personalutils.dao.VehicleDao;
import com.ranjun1999.personalutils.model.FinalSolution;
import com.ranjun1999.personalutils.model.Solution;
import com.ranjun1999.personalutils.model.Vehicle;
import com.ranjun1999.personalutils.service.QuestionService;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/5/21 10:02
 */
public class QuestionServiceImpl implements QuestionService {


    QuestionDao questionDao;

    SolutionDao solutionDao;

    NodeDao nodeDao;

    VehicleDao vehicleDao;


    @Override
    public int addQuestion(String questionName) {
        return 0;
    }

    @Override
    public List<Solution> executeRunPath(int questionId, int choice) {
        return null;
    }

    @Override
    public void selectFinalPath(FinalSolution finalSolution) {

    }
}
