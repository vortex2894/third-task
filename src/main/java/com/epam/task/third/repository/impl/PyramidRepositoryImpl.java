package com.epam.task.third.repository.impl;

import com.epam.task.third.entities.IdentifiablePyramid;
import com.epam.task.third.entities.Pyramid;
import com.epam.task.third.repository.PyramidRepository;
import com.epam.task.third.repository.PyramidSpecification;
import com.epam.task.third.exceptions.RepositoryException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidRepositoryImpl implements PyramidRepository {

    private final Map<Long, IdentifiablePyramid> pyramids;

    public PyramidRepositoryImpl() {
        pyramids = new HashMap<>();
    }

    @Override
    public void addPyramid(IdentifiablePyramid pyramid) {
        pyramids.put(pyramid.getId(), pyramid);
    }

    @Override
    public void removePyramid(IdentifiablePyramid pyramid) throws RepositoryException {
        if (!pyramids.containsKey(pyramid.getId())) {
            throw new RepositoryException("Pyramid" + pyramid.toString() + " not found");
        }
        long key = pyramid.getId();
        pyramids.remove(key);
    }

    @Override
    public void updatePyramid(IdentifiablePyramid pyramid) {
        long key = pyramid.getId();
        pyramids.replace(key, pyramid);
    }

    @Override
    public List<Pyramid> query(PyramidSpecification specification) {
        List<Pyramid> listOfPyramids = new ArrayList<>();
        for (IdentifiablePyramid pyramid : pyramids.values()) {
            if (specification.isSpecified(pyramid)) {
                listOfPyramids.add(pyramid);
            }
        }
        return listOfPyramids;
    }

    public Map<Long, IdentifiablePyramid> getPyramids() {
        return pyramids;
    }
}
