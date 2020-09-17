package com.ranjun1999.personalutils.dao;

import com.ranjun1999.personalutils.model.Question;

import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/5/21 9:58
 */
public interface QuestionDao {

    void addQuestion(Question question);

    void modifyQuestion(Question question);

    Question getQuestion(int questionId);

    void delQuestion(int questionId);
}
