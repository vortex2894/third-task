package com.epam.task.third.repository;

import com.epam.task.third.entities.IdentifiablePyramid;
import com.epam.task.third.exceptions.RepositoryException;

import java.util.List;

public interface PyramidRepository {

    void addPyramid(IdentifiablePyramid pyramid);
    void removePyramid(IdentifiablePyramid pyramid) throws RepositoryException;
    void updatePyramid(IdentifiablePyramid pyramid);
    List query(PyramidSpecification specification);
}
