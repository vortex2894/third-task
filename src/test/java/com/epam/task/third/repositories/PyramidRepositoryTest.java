package com.epam.task.third.repositories;

import com.epam.task.third.entities.IdentifiablePyramid;
import com.epam.task.third.exceptions.RepositoryException;
import com.epam.task.third.repositories.impl.PyramidRepositoryImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidRepositoryTest {

    private static final  IdentifiablePyramid FIRST_PYRAMID =
            new IdentifiablePyramid(Arrays.asList(4, 5, 6, 2, 4, 7, 6, 2, 1, 4, 7, 2));
    private static final  IdentifiablePyramid SECOND_PYRAMID =
            new IdentifiablePyramid(Arrays.asList(2, 7, 4, 1, 1, 1, 9, 5, 7, 3, 6, 3));

    private static PyramidRepository repository;

    private static PyramidVolumeLessThanSpecification specification;

    @BeforeClass
    public static void init() {
        repository = new PyramidRepositoryImpl();
        specification = new PyramidVolumeLessThanSpecification(10);

    }

    @Test
    public void testInsertPyramidIntoRepository(){

        repository.addPyramid(FIRST_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);

        Map<Long,IdentifiablePyramid> actual = repository.getPyramids();

        Map<Long, IdentifiablePyramid> expected = new HashMap<Long, IdentifiablePyramid>(){{
            put(FIRST_PYRAMID.getId(), FIRST_PYRAMID);
            put(SECOND_PYRAMID.getId(), SECOND_PYRAMID);
        }};
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemovePyramidFromRepository() throws RepositoryException {

        repository.addPyramid(FIRST_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);

        repository.removePyramid(FIRST_PYRAMID);
        repository.removePyramid(SECOND_PYRAMID);

        Map<Long, IdentifiablePyramid> expected = new HashMap<>();
        Map<Long,IdentifiablePyramid> actual = repository.getPyramids();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testQueryShouldReturnListOfAllPyramidsSuitableForSpecification(){
        PyramidRepositoryImpl repository = new PyramidRepositoryImpl();
        repository.addPyramid(FIRST_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);
        List<IdentifiablePyramid> expected = new ArrayList<>(Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID));
        List actual = repository.query(specification);
        Assert.assertEquals(expected, actual);
    }
}
