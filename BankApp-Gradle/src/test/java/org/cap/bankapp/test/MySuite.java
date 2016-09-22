package org.cap.bankapp.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({  BankAppTestCases.class, ParameterizedTestCase.class,
		RulesDemo.class })
@IncludeCategory({GoodTestCategory.class})
@ExcludeCategory({BadTestCategory.class})
public class MySuite {

}
