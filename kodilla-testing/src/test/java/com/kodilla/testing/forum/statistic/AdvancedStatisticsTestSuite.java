package com.kodilla.testing.forum.statistic;

import com.kodilla.testing.forum.statistics.AdvancedStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Advanced Statistics Test Suite")
public class AdvancedStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private static int testCounter = 0;

    @BeforeEach
    public void initEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
        statisticsMock = mock(Statistics.class);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(50);
        List<String> listOfUsers10 = generateListOfUsers(10);
        when(statisticsMock.usersNames()).thenReturn(listOfUsers10);
    }

    private List<String> generateListOfUsers(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            resultList.add("User" + n+1);
        }
        return resultList;
    }


    @Test
        void testCalculateAdvStatisticsNumberOfPost0(){
            //Given
            AdvancedStatistics advancedStatistics = new AdvancedStatistics();
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            advancedStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, advancedStatistics.getNumberOfPosts());
            assertEquals(0, advancedStatistics.getAverageNumberOfPostsPerUser());
            assertEquals(10, advancedStatistics.getAverageNumberOfCommentsPerUser());
            assertEquals(0, advancedStatistics.getAverageNumberOfCommentsPerPost());
        }


    @Test
        void testCalculateAdvStatisticsNumberOfPost1000(){
            //Given
            AdvancedStatistics advancedStatistics = new AdvancedStatistics();
            when(statisticsMock.postsCount()).thenReturn(1000);

            //When
            advancedStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(1000, advancedStatistics.getNumberOfPosts());
            assertEquals(100, advancedStatistics.getAverageNumberOfPostsPerUser());
            assertEquals(10, advancedStatistics.getAverageNumberOfCommentsPerUser());
            assertEquals(0.1, advancedStatistics.getAverageNumberOfCommentsPerPost());

        }
    @Test
        void testCalculateAdvStatisticsNumberOfComments0(){
            //Given
            AdvancedStatistics advancedStatistics = new AdvancedStatistics();
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            advancedStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, advancedStatistics.getNumberOfComments());
            assertEquals(5, advancedStatistics.getAverageNumberOfPostsPerUser());
            assertEquals(0, advancedStatistics.getAverageNumberOfCommentsPerUser());
            assertEquals(0, advancedStatistics.getAverageNumberOfCommentsPerPost());
        }

    @Test
        void testCalculateAdvStatisticsNumberOfCommentsLessThanNumberOfPosts(){
            //Given
            AdvancedStatistics advancedStatistics = new AdvancedStatistics();
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.commentsCount()).thenReturn(20);

            //When
            advancedStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(10, advancedStatistics.getAverageNumberOfPostsPerUser());
            assertEquals(2, advancedStatistics.getAverageNumberOfCommentsPerUser());
            assertEquals(0.2, advancedStatistics.getAverageNumberOfCommentsPerPost());
        }

    @Test
        void testCalculateAdvStatisticsNumberOfCommentsMoreThanNumbersOfPosts() {
            //Given
            AdvancedStatistics advancedStatistics = new AdvancedStatistics();

            //When
            advancedStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(5, advancedStatistics.getAverageNumberOfPostsPerUser());
            assertEquals(10, advancedStatistics.getAverageNumberOfCommentsPerUser());
            assertEquals(2, advancedStatistics.getAverageNumberOfCommentsPerPost());
        }

    @Test
        void testCalculateAdvStatisticsNumberOfUsers0(){
            //Given
            AdvancedStatistics advancedStatistics = new AdvancedStatistics();
            List<String> listOfUsers0 = generateListOfUsers(0);
            when(statisticsMock.usersNames()).thenReturn(listOfUsers0);

            //When
            advancedStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, advancedStatistics.getNumberOfUsers());
            assertEquals(0, advancedStatistics.getAverageNumberOfPostsPerUser());
            assertEquals(0, advancedStatistics.getAverageNumberOfCommentsPerUser());
            assertEquals(2, advancedStatistics.getAverageNumberOfCommentsPerPost());
        }

    @Test
        void testCalculateAdvStatisticsNumberOfUsers1000(){
            //Given
            AdvancedStatistics advancedStatistics = new AdvancedStatistics();
            List<String> listOfUsers1000 = generateListOfUsers(1000);
            when(statisticsMock.usersNames()).thenReturn(listOfUsers1000);

            //When
            advancedStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(1000, advancedStatistics.getNumberOfUsers());
            assertEquals(0.05, advancedStatistics.getAverageNumberOfPostsPerUser());
            assertEquals(0.1, advancedStatistics.getAverageNumberOfCommentsPerUser());
            assertEquals(2, advancedStatistics.getAverageNumberOfCommentsPerPost());
        }

    }
