package com.epam.task.third.repository;

import com.epam.task.third.entities.IdentifiablePyramid;

public interface PyramidSpecification {

    boolean isSpecified(IdentifiablePyramid pyramid);
}
