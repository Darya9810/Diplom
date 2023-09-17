package ru.netology.qa.tests;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elements.AuthorizationScreen;
import ru.netology.qa.elements.ClaimsScreen;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Заявки мобильного приложения Мобильный хоспис")
public class ClaimsTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorizationCheck() {
        AuthorizationSteps.authorization();
    }

    @AfterClass
    public static void exit() {
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "Заявки" мобильного приложения "Мобильный хоспис".

    //  TC - 9 - Фильтрация заявок по критерию "Открыта" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).

    @Test
    @Story("TC - 9")
    @Description("Фильтрация заявок по критерию Открыта во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringInProgress() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickButtonOk();
    }

    //  TC - 10 - Фильтрация заявок по критерию "В работе" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 10")
    @Description("Фильтрация заявок по критерию В работе во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringOpen() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
    }


    //  TC - 11 - Поле "Исполнитель" состоит из букв и цифр, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 11")
    @Description("Поле Исполнитель состоит из букв и цифр, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldConsistsLettersAndNumbers() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldConsistsLettersAndNumbers();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 12 - Поле "Исполнитель" состоит из спецсимволов, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 12")
    @Description("Поле Исполнитель состоит из спецсимволов, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldSpecialCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldSpecialCharacters();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 13 - Поле "Дата" состоит из даты будущего года, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 13")
    @Description("Поле Дата состоит из даты будущего года, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void descriptionFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateFieldNextYear();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

}
