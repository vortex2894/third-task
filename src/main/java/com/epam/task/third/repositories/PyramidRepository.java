package com.epam.task.third.repositories;

import com.epam.task.third.entities.IdentifiablePyramid;
import com.epam.task.third.entities.Pyramid;
import com.epam.task.third.exceptions.RepositoryException;

import java.util.List;
import java.util.Map;

public interface PyramidRepository {

    void addPyramid(IdentifiablePyramid pyramid);
    void removePyramid(IdentifiablePyramid pyramid) throws RepositoryException;
    void updatePyramid(IdentifiablePyramid pyramid);
    Map<Long, IdentifiablePyramid> getPyramids();
    List<Pyramid> query(PyramidSpecification specification);
}
