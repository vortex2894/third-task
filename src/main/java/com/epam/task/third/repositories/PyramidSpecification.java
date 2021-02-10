package com.epam.task.third.repositories;

import com.epam.task.third.entities.IdentifiablePyramid;

public interface PyramidSpecification {

    boolean isSpecified(IdentifiablePyramid pyramid);
}
