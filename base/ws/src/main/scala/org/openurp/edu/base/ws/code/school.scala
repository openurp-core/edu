package org.openurp.edu.base.ws.code

import org.openurp.edu.base.code.model.{ CourseCategory, CourseType, ExamMode, ExamStatus, StdLabel, StdLabelType, StdType }
import org.openurp.code.edu.model.StudentStatus

class StdLabelWS extends AbstractWS[StdLabel]

class StdLabelTypeWS extends AbstractWS[StdLabelType]

class StdTypeWS extends AbstractWS[StdType]

class StdStatusWS extends AbstractWS[StudentStatus]

class CourseTypeWS extends AbstractWS[CourseType]

class CourseCategoryWS extends AbstractWS[CourseCategory]

class ExamModeWS extends AbstractWS[ExamMode]

class ExamStatusWS extends AbstractWS[ExamStatus]