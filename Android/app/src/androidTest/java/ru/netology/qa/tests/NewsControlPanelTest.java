package ru.netology.qa.tests;

import static androidx.test.espresso.Espresso.pressBack;

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
import ru.netology.qa.elements.NewsControlPanelScreen;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;
import ru.netology.qa.steps.NewsControlPanelSteps;
import ru.netology.qa.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования Панели Управления Новостей мобильного приложения Мобильный хоспис")

public class NewsControlPanelTest {

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

// Тест-кейсы для проведения функционального тестирования "Панели Управления Новостей" мобильного приложения "Мобильный хоспис".

    //  TC - 17 - Сортировка новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 17")
    @Description("Сортировка новостей во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void sortingNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelScreen.clickButtonControlPanel();
        NewsControlPanelScreen.clickButtonSorting();
    }

    //  TC - 18 - Просмотр новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 18")
    @Description("Просмотр новостей во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void viewingNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
    }


    //  TC - 19 - Фильтрация новостей по критерию "Не активна", во вкладке "Панель управления" новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 19")
    @Description("Фильтрация новостей по критерию Не активна, во вкладке Панель управления новостей мобильного приложения Мобильный хоспис (Позитивный)")
    public void filterNewsByCriterionNotActive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxNotActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
    }

}