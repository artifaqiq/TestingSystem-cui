package com.nc.dev3.lomako;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.beans.test.TestAnswers;
import com.nc.dev3.lomako.utils.BeansCreator;
import com.nc.dev3.lomako.utils.TestResultCalculator;
import junit.framework.TestCase;

/**
 * Created by arturlomako on 3/21/17.
 */
public class BeansTest extends TestCase {

    private BeansCreator beansCreator = new BeansCreator();

    public void testCategory() {
        Category category = beansCreator.createExampleCategory();
        System.out.println(category);
        System.out.println("Number of Test entity: " + category.getTests().get(0).numberOfEntities);
    }

    public void testTestAnswers() {
        TestAnswers answers = beansCreator.createExampleTestAnswers();
        System.out.println(answers);
    }

    public void testTestResultCalculator() {
        TestAnswers answers = beansCreator.createExampleTestAnswers();
        assertTrue(TestResultCalculator.calculateTestResult(answers) == 100);
        assertTrue(TestResultCalculator.calculateMaxTestResult(answers.getTest()) == 300);
    }
}
